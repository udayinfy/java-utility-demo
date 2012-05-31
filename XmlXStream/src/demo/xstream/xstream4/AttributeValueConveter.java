package demo.xstream.xstream4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
  

public class AttributeValueConveter implements Converter {  
  
    public String textName = "value";  
    private Mapper mapper;  
    private List convertClass = new ArrayList();  
  
    public AttributeValueConveter(Mapper mapper) {  
        this.mapper = mapper;  
    }  
  
    public void marshal(Object obj, HierarchicalStreamWriter wt, MarshallingContext context) {  
        Field[] values = obj.getClass().getDeclaredFields();  
        for (int i = 0; i < values.length; i++) {  
            Field value = values[i];  
            String name = value.getName();  
            if (name.equals(textName)) {  
                continue;  
            }  
            try {  
                if (!value.isAccessible()) {  
                    value.setAccessible(true);  
                }  
                Object v = value.get(obj);  
                if (v == null) {  
                    continue;  
                }  
                if (Number.class.isAssignableFrom(v.getClass()) || v.getClass().isPrimitive()) {  
                    wt.addAttribute(mapper.serializedMember(obj.getClass(), name), String.valueOf(v));  
                } else {  
                    wt.addAttribute(mapper.serializedMember(obj.getClass(), name), v.toString());  
                }  
            } catch (Exception e) {  
                throw new ObjectAccessException("Cannot set Field " + value.getName() + obj.getClass(), e);  
            }  
        }  
        try{  
            Field field = obj.getClass().getDeclaredField(textName);  
            if(!field.isAccessible()){  
                field.setAccessible(true);  
            }  
            Object v = field.get(obj);  
            if (null != v && !"".equals(v.toString())) {  
                wt.setValue(v.toString());  
            }  
        } catch (Exception e) {  
            throw new ObjectAccessException("Cannot set Field " + textName + obj.getClass(), e);  
        }  
    }  
  
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {  
        Object obj = context.currentObject();  
        if (obj == null) {  
            try {  
                obj = context.getRequiredType().newInstance();  
            } catch (Exception e) {  
                throw new ObjectAccessException("Cannot construct " + context.getRequiredType().getName(), e);  
            }  
        }  
  
        Iterator attNames = reader.getAttributeNames();  
        while (attNames.hasNext()) {  
            String attName = (String) attNames.next();  
            if (attName.equals(textName)) {  
                continue;  
            }  
  
            try {  
                Field field = obj.getClass().getDeclaredField(mapper.realMember(obj.getClass(), attName));  
                if (!field.isAccessible()) {  
                    field.setAccessible(true);  
                }  
                String v = reader.getAttribute(attName);  
                if (null == v || "".equals(v)) {  
                    continue;  
                }  
                Class fieldType = field.getType();  
                Constructor strnum = fieldType.getDeclaredConstructor(String.class);  
                field.set(obj, strnum.newInstance(v));  
            } catch (Exception e) {  
                e.printStackTrace();  
                throw new ObjectAccessException("Cannot construct " + obj.getClass(), e);  
            }  
        }  
        String value = reader.getValue();  
        if (null != value && !"".equals(value)) {  
            try {  
                Field field = obj.getClass().getDeclaredField(mapper.realMember(obj.getClass(), textName));  
                if (!field.isAccessible()) {  
                    field.setAccessible(true);  
                }  
                field.set(obj, value);  
            } catch (Exception e) {  
                e.printStackTrace();  
                throw new ObjectAccessException("Cannot construct " + obj.getClass(), e);  
            }  
        }  
        return obj;  
    }  
  
    public boolean canConvert(Class clazz) {  
        /*Iterator it = convertClass.iterator(); 
        while (it.hasNext()) { 
            Class c = (Class) it.next(); 
            if (c.equals(clazz)) { 
                return true; 
            } 
        }return false;*/  
        return convertClass.contains(clazz);  
    }  
  
    public Iterator getConvertClass() {  
        return convertClass.iterator();  
    }  
  
    public void addConvertClass(Class cc) {  
        this.convertClass.add(cc);  
    }  
  
    public String getTextName() {  
        return textName;  
    }  
    public void setTextName(String textName) {  
        this.textName = textName;  
    }  
}

