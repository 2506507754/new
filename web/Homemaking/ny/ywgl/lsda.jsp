<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<link href="../css/button.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.STYLE1 {
	font-size: 36px;
	font-weight: bold;
}
-->
</style>
<head>
<title>Untitled Document</title>
<script type="text/javascript" src="../js/public.js"></script>
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
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;雇主信息</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>


  <table width="96%" height="65" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
<tr>
      <td width="67%" height="65" align="right" valign="top" nowrap class="text">&nbsp;&nbsp; <div align="center"><span class="STYLE1">客户 ${sessionScope.Customer.employer_name} 档案</span></div>
      <div align="center" class="STYLE1"></div></td>
    </tr>
  </table>
<br>
 <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#bdc7d3">
  <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td width="20%" height="14" align="right" nowrap><strong>客户号： </strong>${sessionScope.Customer.employer_number}</td>
      <td width="53%" height="14" align="right" nowrap><strong>建档时间：</strong>${sessionScope.Customer.check_in_time}</td>
      <td width="27%" align="center" nowrap>&nbsp;</td>
    </tr>
    </table>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
  <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td height="14" colspan="4" align="center" nowrap><strong>身份证号码</strong></td>
      <td align="center" nowrap><strong>常住地址</strong></td>
      <td colspan="2" align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap><strong>电话</strong></td>
      <td colspan="2" align="center" nowrap>&nbsp;</td>
    </tr>
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td height="14" colspan="4" align="center" nowrap>${sessionScope.Customer.idnumber}</td>
      <td align="center" nowrap><strong>${sessionScope.Customer.service_address}</strong></td>
      <td colspan="2" align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap><strong>${sessionScope.Customer.telephone}</strong></td>
      <td colspan="2" align="center" nowrap>&nbsp;</td>
    </tr>
      <tr align="center" class="tdtitle">
          <td nowrap align="center" width="3%">序号</td>
          <td width="12%" align="center" nowrap id=".name"><strong>工人</strong></td>
          <td width="11%" height="24" align="center" nowrap id=".name">
              <div align="center" orderBy="true"><strong>编号</strong></div>
          </td>
          <td width="12%" height="24" align="center" nowrap id=".phone">
              <div align="center" orderBy="true"><strong>介绍费</strong></div>
          </td>
          <td width="16%" align="center" nowrap id=".title">
              <div align="center" orderBy="true"><strong>登记时间</strong></div>
          </td>
          <td width="13%" align="center" nowrap id=".register">
              <div align="center" orderBy="true"><strong>上岗时间</strong></div>
          </td>
          <td width="9%" align="center" nowrap id=".register"><strong>工作内容</strong></td>
          <td width="14%" align="center" nowrap id=".submit_date">工资</td>
          <td width="14%" align="center" nowrap id=".submit_date"><strong>离职时间</strong></td>
          <td width="10%" align="center" nowrap id=".submit_date"><strong>离职原因</strong></td>
      </tr>
      <c:forEach items="${sessionScope.contract}" var="contract" varStatus="number">
          <tr align="center" class="td2" onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
              <td nowrap align="center" width="3%">${number.count}</td>
              <td align="center" nowrap>${contract.worker_name}</td>
              <td height="14" align="center" nowrap>${contract.worker_number}</td>
              <td align="center" nowrap>${contract.fee}</td>
              <td align="center" nowrap>${contract.entry_time}</td>
              <td align="center" nowrap>${contract.check_in_time}</td>
              <td align="center" nowrap>${contract.employement_type}</td>
              <td align="center" nowrap>${contract.pay}</td>
              <td align="center" nowrap>${contract.closeing_date}&nbsp;</td>
              <td align="center" nowrap>&nbsp;</td>
          </tr>
      </c:forEach>
  </table>
<table width="96%" height="10"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td><input type="hidden" name="orderType" value="asc">
            <input type="hidden" name="orderFid" value=".submit_date">
            <table width="90%" style="font-size:12px;" border="0" cellspacing="3" cellpadding="2">
                <tr>
                    <td nowrap width="45%" align="center"> 当前第${sessionScope.page+1}页 共${sessionScope.count}记录 分${Integer.valueOf(Math.ceil(sessionScope.count/5))}页显示 </td>
                    <td nowrap width="55%" align="right">
                        <input type="hidden" name="currentPage" value="1">
                        <input type="hidden" name="paginationAction" value="${sessionScope.page}">
                        <input type="hidden" name="paginationAction2" value="${Integer.valueOf(Math.ceil(sessionScope.count/5))}">
                        <img src="../image/First_no.gif" alt="第一页" width="18" height="13" border="0" onclick="doDBClick('${pageContext.request.contextPath}/Homemaking/manageSvl?reqType=${sessionScope.reqType}&page=first',true,null)"/>&nbsp&nbsp&nbsp
                        <img src="../image/Previous_no.gif" alt="上一页" width="14" height="13" border="0" onclick="doDBClick('${pageContext.request.contextPath}/Homemaking/manageSvl?reqType=${sessionScope.reqType}&page=old',true,null) "/>&nbsp&nbsp&nbsp
                        <img src="../image/Next_no.gif" alt="下一页" width="14" height="13" border="0" onclick="doDBClick('${pageContext.request.contextPath}/Homemaking/manageSvl?reqType=${sessionScope.reqType}&page=new',true,null)"/>&nbsp&nbsp&nbsp
                        <img src="../image/Last_no.gif" alt="最后一页" width="18" height="13" border="0" onclick="doDBClick('${pageContext.request.contextPath}/Homemaking/manageSvl?reqType=${sessionScope.reqType}&page=last',true,null) "/>&nbsp&nbsp&nbsp
                        <a  onClick="doDBClick('${pageContext.request.contextPath}/Homemaking/manageSvl?reqType=${sessionScope.reqType}&page=jump',true,null)">前往</a>
                        <input type=text size='4' onlytype='int'  name='pageSelect' value=''/>
                        页 </td>
                </tr>
            </table>

        </td>
    </tr>
</table>

</body>
</html>
