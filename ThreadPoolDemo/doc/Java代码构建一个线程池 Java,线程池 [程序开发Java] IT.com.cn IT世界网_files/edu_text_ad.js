//document.write ("<table  bgcolor=#DEEFFF  border='0' cellspacing='0' cellpadding='3' class=linktable style='border:#93C1F5 1px solid'>");

document.write ("<table  bgcolor=#FBF5C6  border='0' cellspacing='0' cellpadding='3' class=linktable style='border:#F4BF20 1px solid'>");
document.write (" <tr >");







document.write ("    <td nowrap width=180><a href='http://www.sogou.com/?pid=59021101' target='_blank' ><font color='#000000'>·上网柴米油盐酱醋搜狗俱备</font></a></td>");








document.write ("     <td >");





















var arrBaiduCproConfig=new Array();
arrBaiduCproConfig['uid'] = 81802;
arrBaiduCproConfig['n'] = 'itcomcncpr';
arrBaiduCproConfig['tm'] = 30;
arrBaiduCproConfig['cm'] = 0;
arrBaiduCproConfig['um'] = 0;
arrBaiduCproConfig['rad'] =1;
arrBaiduCproConfig['w'] = 450;
arrBaiduCproConfig['h'] = 15;
arrBaiduCproConfig['bd'] = '#FBF5C6';
arrBaiduCproConfig['bg'] = '#FBF5C6';
arrBaiduCproConfig['tt'] = '#ff0000';
arrBaiduCproConfig['ct'] = '#000000';
arrBaiduCproConfig['url'] = '#666666';
arrBaiduCproConfig['bdl'] = '#ffffff';
arrBaiduCproConfig['wn'] = 2;
arrBaiduCproConfig['hn'] = 1;
arrBaiduCproConfig['ta'] = 'right';
arrBaiduCproConfig['tl'] = 'bottom';
arrBaiduCproConfig['bu'] = 0;




var intBaiduCproDebug = 0;	
var strBaiduCproUiUrl = 'http://cpro.baidu.com/cpro/ui/uijs.php?';
var strBaiduCproTestUiName = 'baiduCPRO0101';

function ss(w)
{
    window.status=w;
    return true;
}

function baiduCproWriteStyle()
{
	strBaiduCproStyle = '<style type="text/css">'
	strBaiduCproStyle += '<!--';
	strBaiduCproStyle += 'table.baidu_cpro_table td,table.baidu_cpro_table a,table.baidu_cpro_table div{font-size:12px;font-family:Arial; table-layout:fixed; word-break:break-all;overflow:hidden;}';
	strBaiduCproStyle += 'table.baidu_cpro_table a:link.baidu_cpro_title{text_decoration:underline},table.baidu_cpro_table a:visited.baidu_cpro_title{text-decoration:underline;}';
	strBaiduCproStyle += 'table.baidu_cpro_table a:active.baidu_cpro_title{text_decoration:none},table.baidu_cpro_table a:hover.baidu_cpro_title{text-decoration:none;}';
	strBaiduCproStyle += '//-->';
	strBaiduCproStyle += '</style>';
	return strBaiduCproStyle;
}

function baiduCproTableBuild(strBaiduCproData, bolDebug)
{
	intBaiduCproRow=arrBaiduCproConfig['hn'];
	intBaiduCproCol=arrBaiduCproConfig['wn'];

	if(arrBaiduCproConfig['bd'].toLowerCase()=='#trans')	
	{
		arrBaiduCproConfig['bd']='""';
		thick=0;
	}
	else
	{
		thick=1;
	}
	if(arrBaiduCproConfig['bg'].toLowerCase()=='#trans')
	{
		arrBaiduCproConfig['bg']='""';
	}


	strBaiduCproTitleUrl = 'http://union.baidu.com/';
	
	intBaiduCproTdLeave=100-Math.floor(100/intBaiduCproCol)*intBaiduCproCol;

	arrBaiduCproData = strBaiduCproData.split('\n');
	for(i=0;i<arrBaiduCproData.length;i++)
	{
		arrBaiduCproData[i] = arrBaiduCproData[i].split('\t');
	}

	strBaiduCproOut='';
	if(arrBaiduCproData[0].length==2)
	{
		strBaiduCproOut+='<center><a href=\"'+arrBaiduCproData[0][1]+'\" target=\"_blank\">';
		strBaiduCproOut+='<img border=0 src=\"'+arrBaiduCproData[0][0]+'\"></a></center>';
	}
	else
	{
		strBaiduCproOut = '<table align=center width='+arrBaiduCproConfig['w']+' height='+arrBaiduCproConfig['h']+' cellpadding=1 cellspacing=0 bgcolor='+arrBaiduCproConfig['bd']+' style="border:'+thick+'px solid '+arrBaiduCproConfig['bd']+';" class="baidu_cpro_table">';
		if(intBaiduCproCol>arrBaiduCproData.length)
		{
			 intBaiduCproCol = arrBaiduCproData.length;
		}
		intBaiduCproRow = Math.ceil(arrBaiduCproData.length/intBaiduCproCol);

		intBaiduCproTdWidth_t = Math.floor(100/intBaiduCproCol);
	        intBaiduCproTdWidth=0;
		intBaiduCproTdHeight = Math.ceil((arrBaiduCproConfig['h']-22)/intBaiduCproRow);

		index = 0;
		for(i = 0; i < intBaiduCproRow; i++)
		{
			strBaiduCproOut +='<tr>';
			for(j = 0; j < intBaiduCproCol; j++)
			{
				if(j < intBaiduCproTdLeave)
				{
					intBaiduCproTdWidth=intBaiduCproTdWidth_t+1;
				}
				else
				{
					intBaiduCproTdWidth=intBaiduCproTdWidth_t;
				}
				strBaiduCproOut +='<td style="line-height:18px; padding:0px 0px 0px 0px; border:0px;'+(i!=0?' border-top:'+thick+'px solid '+arrBaiduCproConfig['bd']+';':'')+' background-color:'+arrBaiduCproConfig['bg']+';width:'+intBaiduCproTdWidth+'%; height:'+intBaiduCproTdHeight+'px;" bgcolor="'+arrBaiduCproConfig['bg']+'" height="'+intBaiduCproTdHeight+'"width="'+intBaiduCproTdWidth+'%" valign="middle"'; 
				if (index >= arrBaiduCproData.length)
				{
					strBaiduCproOut+='>';				
					break;
				}
				else
				{
					strBaiduCproOut += 'onmouseover="return ss(\'链接至 ' + arrBaiduCproData[index][2].replace(/^(\w+:\/\/)?([^\/]+).*$/ig,'$2') + '\')" onmouseout="return ss(\' \')">';
					if(arrBaiduCproData[index][3].match(/^http:\/\/([\w\-]*\.)*baidu\.com\.?(:\d+)?\/?/ig))
					{
						arrBaiduCproData[index][3]+='&referer='+location.href.replace(/^.*&word=([^&]+).*$/ig,'$1');
					}
					strBaiduCproOut +='<div><a href="'+arrBaiduCproData[index][3]+'" target="_blank" class="baidu_cpro_title" style="color:'+arrBaiduCproConfig['tt']+';font-weight:bold;line-height:14px;width:100%;display:block;"><b>';
					if(arrBaiduCproData[index].length == 6 && arrBaiduCproConfig['nfr'] == 0)
					{
						if(arrBaiduCproConfig['tt'] == '#e10900')
							strTT = '#0000cc';
						else
							strTT = '#e10900';
						strTitle = arrBaiduCproData[index][0].replace(eval('/('+RegexEscape(arrBaiduCproData[index][4])+')/ig'), '<font color="'+strTT+'">$1</font>');
					}
					else
					{
						strTitle = arrBaiduCproData[index][0];
					}
					strBaiduCproOut +=strTitle+'</b></a></div>';
					strBaiduCproOut +='<a href="'+arrBaiduCproData[index][3]+'" target="_blank" style="text-decoration:none; line-height:14px;width:100%;display:block;"';
					if(arrBaiduCproData[index][1]!='...')
					{
						strBaiduCproOut +='<div style=" color:'+arrBaiduCproConfig['ct']+';text-decoration:none;">'+arrBaiduCproData[index][1]+'</div>';
					}

					if(arrBaiduCproConfig['bu']=='1' || arrBaiduCproConfig['bu']==1)
					{
						strBaiduCproOut +='<div style="color:'+arrBaiduCproConfig['url']+';text-decoration:none;font-size:11px">'+arrBaiduCproData[index][2].replace(/^(\w+:\/\/)?([^\/]+).*$/ig,'$2')+'</div>';
					}
					strBaiduCproOut +='</a>';
					index++;
				}
				strBaiduCproOut +='</td>';
			}
			strBaiduCproOut +='</tr>';
			if (index>=arrBaiduCproData.length)
			{
				break;
			}
		}

		strBaiduCproOut += '</table>';
		strBaiduCproOut = baiduCproWriteStyle()+strBaiduCproOut;
	}
	
	if (intBaiduCproDebug==1)
	{
		return strBaiduCproOut;
	}
	else
	{
		document.write(strBaiduCproOut);
	}
}

function baiduCproGetUri(strBaiduCproUrl)
{
	strBaiduCproGetParamMap = ',w|rsi0,h|rsi1,bu|rsi2,nfr|rsi5,bd|rss0,bg|rss1,tt|rss2,ct|rss3,url|rss4,bdl|rss5,ta|rssl0,tl|rssl1,';

	strBaiduCproUiUri = strBaiduCproUiUrl;
	for (key in arrBaiduCproConfig){
		if ((key =='uid')||(key =='n')||(key =='tm')||(key =='cm')||(key =='um')||(key =='rad')||(key =='w')||(key =='h')||(key =='bd')||(key =='bg')||(key =='tt')||(key =='ct')||(key =='url')||(key =='bdl')||(key =='wn')||(key =='hn')||(key=='bu')||(key == 'ta')||(key == 'tl'))
		{
			strBaiduCproUiUrlRegExp = '/^.*,'+key+'\\|([^,]+),.*$/ig';
			strBaiduCproUiUrlParamName = eval('strBaiduCproGetParamMap.match(' + strBaiduCproUiUrlRegExp + ')?strBaiduCproGetParamMap.replace(' + strBaiduCproUiUrlRegExp + ',"$1"):"' + key + '"');
			strBaiduCproUiUri += '&'+strBaiduCproUiUrlParamName+'='+escape(arrBaiduCproConfig[key]);
		}
	}
	if(strBaiduCproUrl=='')	{
		strBaiduCproUrl= document.referrer;
		if (top.location == document.location) 	{
		      strBaiduCproUrl = document.location;    
		}
	}
	strBaiduCproUiUri += '&word=';
	strBaiduCproUiUri += typeof(encodeURIComponent)=='function' ? encodeURIComponent(strBaiduCproUrl) : escape(strBaiduCproUrl);
	strBaiduCproUiUri += '&tn=';
	strBaiduCproUiUri += strBaiduCproTestUiName;
	return strBaiduCproUiUri;

}
function baiduCproGetIFrame()
{
	return '<iframe marginWidth=0 marginHeight=0 scrolling=no frameBorder=0 width='+arrBaiduCproConfig['w']+' height='+arrBaiduCproConfig['h']+' allowtransparency="1"  ;  src="'+baiduCproGetUri('')+' "></iframe>';		
}

function baiduCproIFrame()
{
	var myBaiduCpro=document.getElementById("baiduCpro");	
	var strBaiduCproRet="";
	if(myBaiduCpro!=null)
	{	
		strBaiduCproRet+="<script language=\"javascript\">";
		strBaiduCproRet+="document.getElementById(\"baiduCpro\").innerHTML = baiduCproGetIFrame();"
		strBaiduCproRet+="</script>"	
	}
	else
	{
		strBaiduCproRet+=baiduCproGetIFrame();		
	}
	return strBaiduCproRet;
}

function RegexEscape(str)
{
	regstr = /([\\\/\.\?\+\*\(\)\[\]\{\}\^\$\|\=\!\:])/g;
	return str.replace(regstr, '\\$1');
}



document.write(baiduCproIFrame());













document.write ("    </td>");

document.write ("    <td class='ch_right' nowrap width=210><a href='http://home.it.com.cn/' target='_blank' ><font color=#ff0000>·注册数字家园新帐号即得1000IT币！</font></a></td>");

document.write ("     <td class='ch_right' nowrap width=65>[<a href=# onClick=\"this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.it.com.cn');return false;\">设为首页</a>]</td></tr></table>");