<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.STYLE2 {font-size: 16px}
.STYLE3 {color: #FF0000}
-->
</style>
<head>
<title>Untitled Document</title>
<script type="text/javascript" src="../tdp/js/validator.js"></script>
<script type="text/javascript" src="../tdp/js/public.js"></script>
<script type="text/javascript" src="../javascript/handleArchive.js"></script>
<script language="JavaScript">
function doDBClick(url,operator,type) {
  if (operator == false) {
    document.forms[0].action = url + "&op=view";
    document.forms[0].submit();
  } else {
    document.forms[0].action = url;
    document.forms[0].submit();
  }
}
</script>
</head>

<body>
<table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
  <tr>
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;业务管理--&gt;订单管理</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>
<table width="96%" height="80" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="67%" height="40" align="center" nowrap class="MENU_line1">家政服务消费者订单</td>
  </tr>
  <tr>
    <td align="right" nowrap class="MENU_line1 STYLE2">订单编号：GZ20006300223</td>
  </tr>
</table>
<br>
<table width="94%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
  <tr>
    <td width="10%" align="right" bgcolor="#FFFFFF">姓名：</td>
    <td width="13%" bgcolor="#FFFFFF"><input name="textarea40" type="text" id="textarea40" value="${sessionScope.e_Dd.employer_name}" size="15" class="pi"></td>
    <td width="12%" align="right" bgcolor="#FFFFFF">性别：</td>
    <td width="17%" bgcolor="#FFFFFF">${sessionScope.e_Dd.gender}</td>
    <td width="10%" align="right" bgcolor="#FFFFFF">年龄：</td>
    <td width="13%" bgcolor="#FFFFFF"><input name="textarea" type="text" id="textarea" value="${sessionScope.e_Dd.age}" size="15" class="pi"></td>
    <td width="10%" align="right" bgcolor="#FFFFFF">民族：</td>
    <td width="15%" bgcolor="#FFFFFF"><input name="textarea2" type="text" id="textarea2" value="${sessionScope.e_Dd.nation}" size="15" class="pi"></td>
  </tr>
  <tr>
    <td align="right" bgcolor="#FFFFFF">籍贯：</td>
    <td bgcolor="#FFFFFF"><input name="textarea5" type="text" id="textarea5" value="${sessionScope.e_Dd.hometown}" size="15" class="pi"></td>
    <td align="right" bgcolor="#FFFFFF">学历：</td>
    <td bgcolor="#FFFFFF"><input name="textarea4" type="text" id="textarea4" value="${sessionScope.e_Dd.education}" size="15" class="pi"></td>
    <td align="right" bgcolor="#FFFFFF">身份证号码：</td>
    <td colspan="3" bgcolor="#FFFFFF"><input name="textarea3" type="text" id="textarea3" value="${sessionScope.e_Dd.idnumber}" size="20" class="pi"></td>
  </tr>
  <tr>
    <td align="right" nowrap bgcolor="#FFFFFF">户口所在地：</td>
    <td colspan="7" bgcolor="#FFFFFF"><input name="textarea12" type="text" id="textarea12" value="${sessionScope.e_Dd.address}" size="65" class="pi"></td>
  </tr>
  <tr>
    <td align="right" nowrap bgcolor="#FFFFFF">手机：</td>
    <td align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea22" value="${sessionScope.e_Dd.telephone}" size="15" class="pi"></td>
    <td align="right" nowrap bgcolor="#FFFFFF">住宅：</td>
    <td align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea22" value="${sessionScope.e_Dd.house}" size="15" class="pi"></td>
    <td align="right" bgcolor="#FFFFFF">职业：</td>
    <td colspan="3" bgcolor="#FFFFFF"><input name="textarea8" type="text" id="textarea10" value="${sessionScope.e_Dd.profession}" size="20" class="pi"></td>
  </tr>
  <tr>
    <td align="right" nowrap bgcolor="#FFFFFF">工作单位：</td>
    <td colspan="7" bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea6" value="${sessionScope.e_Dd.worker_unit}" size="65" class="pi"></td>
  </tr>
  <tr>
    <td align="right" nowrap bgcolor="#FFFFFF">接受工资：</td>
    <td colspan="2" align="left" bgcolor="#FFFFFF">从
      <input name="textarea11" type="text" id="textarea11" value="${sessionScope.e_Dd.min_pay}" size="8" class="pi">
      到
      <input name="textarea23" type="text" id="textarea23" value="${sessionScope.e_Dd.max_pay}" size="8" class="pi"></td>
    <td align="left" bgcolor="#FFFFFF">&nbsp;</td>
    <td align="right" bgcolor="#FFFFFF">介绍费：</td>
    <td colspan="3" bgcolor="#FFFFFF"><input name="textarea24" type="text" id="textarea24" value="${sessionScope.e_Dd.fee}" size="20" class="pi"></td>
  </tr>
  <tr>
    <td align="right" nowrap bgcolor="#FFFFFF">雇用：</td>
    <td colspan="7" bgcolor="#FFFFFF">${sessionScope.e_Dd.claim}</td>
  </tr>
  <tr>
    <td colspan="2" align="right" bgcolor="#FFFFFF">服务处所（地址）：</td>
    <td colspan="6" bgcolor="#FFFFFF"><input name="textarea13" type="text" id="textarea13" value="${sessionScope.e_Dd.service_address}" size="44" class="pi"></td>
  </tr>
  <tr>
    <td rowspan="6" align="center" bgcolor="#FFFFFF">家<br>
      庭<br>
      资<br>
      料</td>
    <td align="right" bgcolor="#FFFFFF">居住地址：</td>
    <td colspan="6" align="left" bgcolor="#FFFFFF"><input name="textarea14" type="text" id="textarea14" value="${sessionScope.e_Dd.home_current_address}" size="44" class="pi"></td>
  </tr>
  <tr>
    <td align="right" bgcolor="#FFFFFF">家庭人数：</td>
    <td colspan="6" bgcolor="#FFFFFF"><input name="textarea15" type="text" id="textarea15" value="${sessionScope.e_Dd.home_people_number}" size="44" class="pi"></td>
  </tr>
  <tr>
    <td align="right" bgcolor="#FFFFFF">服务内容：</td>
    <td colspan="6" bgcolor="#FFFFFF"><input name="textarea16" type="text" id="textarea16" value="${sessionScope.e_Dd.home_service}" size="44" class="pi"></td>
  </tr>
  <tr>
    <td align="right" bgcolor="#FFFFFF">房屋面积：</td>
    <td colspan="6" bgcolor="#FFFFFF"><input name="textarea17" type="text" id="textarea17" value="${sessionScope.e_Dd.home_size}" size="44" class="pi"></td>
  </tr>
  <tr>
    <td align="right" bgcolor="#FFFFFF">饮食习惯：</td>
    <td colspan="6" bgcolor="#FFFFFF"><input name="textarea18" type="text" id="textarea18" value="${sessionScope.e_Dd.home_food}" size="44" class="pi"></td>
  </tr>
  <tr>
    <td align="right" bgcolor="#FFFFFF">其他：</td>
    <td colspan="6" bgcolor="#FFFFFF"><input name="textarea19" type="text" id="textarea19" value="${sessionScope.e_Dd.home_other}" size="44" class="pi"></td>
  </tr>
  <tr>
    <td align="center" nowrap bgcolor="#FFFFFF">要求服务等级：</td>
    <td colspan="7" align="left" bgcolor="#FFFFFF"><input name="textarea20" type="text" id="textarea20" value="${sessionScope.e_Dd.claim}" size="65" class="pi"></td>
  </tr>
  <tr>
    <td align="right" nowrap bgcolor="#FFFFFF">经办人：</td>
    <td align="left" bgcolor="#FFFFFF"><input name="textarea21" type="text" id="textarea21" value="${sessionScope.e_Dd.manager}" size="14" class="pi"></td>
    <td align="right" bgcolor="#FFFFFF">登记日期：</td>
    <td align="left" bgcolor="#FFFFFF"><input name="textarea26" type="text" id="textarea26" value="${sessionScope.e_Dd.check_in_times}" size="14" class="pi"></td>
    <td align="right" bgcolor="#FFFFFF">订单有效期：</td>
    <td align="left" bgcolor="#FFFFFF"><input name="textarea27" type="text" id="textarea27" value="${sessionScope.e_Dd.periods}" size="14" class="pi"></td>
    <td align="right" bgcolor="#FFFFFF">状态：</td>
    <td align="left" bgcolor="#FFFFFF"><span class="text">
      <input value="${sessionScope.e_Dd.status}">
    </span></td>
  </tr>
</table>
<table width="96%" height="63" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="67%" height="63" align="center" nowrap class="text"><input type="submit" name="searchbtn3" value="返  回" class="button_new"onClick="javascript:location.href='${pageContext.request.contextPath}/Homemaking/employmentServlet?reqType=query'" >
        <input type="hidden" name="mod" value="no">
      &nbsp;&nbsp; </td>
  </tr>
</table>
</body>
</html>
