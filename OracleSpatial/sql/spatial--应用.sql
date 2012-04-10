/*
==================================================================================
建表
==================================================================================
*/
--111111111111111111111--
CREATE TABLE T_MAPAREA (
  AREA_ID NUMBER PRIMARY KEY,
  AREA_CODE VARCHAR2(256),
  AREA_NAME VARCHAR2(256),
  GID VARCHAR2(256),
  SHAPE MDSYS.SDO_GEOMETRY
);
--2222222222222222222222--
INSERT INTO USER_SDO_GEOM_METADATA
  (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID)
VALUES
  ('T_MAPAREA',
   'SHAPE',
   MDSYS.SDO_DIM_ARRAY( -- 20X20 GRID
                 MDSYS.SDO_DIM_ELEMENT('X', 0, 20, 0.005),
                 MDSYS.SDO_DIM_ELEMENT('Y', 0, 20, 0.005)),
   8307 -- SRID
   );
--33333333333333333333333--
CREATE INDEX T_MAPAREA_SPATIAL_IDX
ON T_MAPAREA(SHAPE)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;

INSERT INTO T_MAPAREA
VALUES
  (1,
   '0312',
   'AREA_A',
   'GID',
   MDSYS.SDO_GEOMETRY(2003, -- TWO-DIMENSIONAL POLYGON
                8307,
                NULL,
                MDSYS.SDO_ELEM_INFO_ARRAY(1, 1003, 1), -- ONE POLYGON (EXTERIOR POLYGON RING)
                MDSYS.SDO_ORDINATE_ARRAY(3, 3, 6, 3, 6, 5, 4, 5, 3, 3)));

-- Create sequence --
create sequence SEQ_MAPAREA
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

/*
==================================================================================
应用
==================================================================================
*/
select * from t_area;
select * from t_maparea;
select * from shxqyt.t_last_locrecord;


--选取EID下的所有终端
select loc.device_id
  from t_last_locrecord loc
  left join ref_term_pgroup ref on loc.device_id = ref.tid
  left join t_privilage_group grp on ref.gid = grp.gid
 where grp.eid = 'root'

select t.shape.sdo_ordinates from t_maparea t where t.area_id = 0

--选取'某企业'下的所有终端在'某区域'内的终端列表
select lr.*
  from (select mdsys.sdo_geometry(2001,
                                  8307,
                                  mdsys.sdo_point_type(latitude,
                                                       longitude,
                                                       null),
                                  NULL,
                                  NULL) loc,
               t.id tid
          from t_last_locrecord t) rec,
       t_maparea area,
       t_last_locrecord lr
 where area.area_id = 1
   and lr.device_id in
       (select loc.device_id
          from t_last_locrecord loc
          left join ref_term_pgroup ref on loc.device_id = ref.tid
          left join t_privilage_group grp on ref.gid = grp.gid
         where grp.eid = 'root')
   and mdsys.sdo_relate(area.shape, rec.loc, 'mask=contains') = 'TRUE'
         
