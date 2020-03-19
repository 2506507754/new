<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<link href="../css/button.css" rel="stylesheet" type="text/css">
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
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;业务管理--&gt;用工管理</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>


  <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
    <tr>
      <td width="67%" align="right" class="text" nowrap>&nbsp;雇主：
        <input type="text" name="searchName" maxlength="20" size="12" value="" class="input">
        &nbsp; 登记日期：
        <input type="text" name="searchName2" maxlength="20" size="12" value="" class="input">
        到
        <input type="text" name="searchName4" maxlength="20" size="12" value="" class="input">
        &nbsp; 雇用工人：
        <input type="text" name="searchName4" maxlength="20" size="12" value="" class="input">
&nbsp;状态：
<select name="select" id="select" class="input">
  <option selected>请选择</option>
  <option>未成交</option>
  <option>已成交</option>
  <option>在别处成交</option>
  <option>已取消</option>
</select>
        <input type="button" name="searchbtn" value="查  询" class="button_new">
        <input type="button" name="searchbtn2" value="新  增" class="button_new"onClick="javascript:location.href='${pageContext.request.contextPath}/Homemaking/employmentServlet?reqType=insert'" >
      &nbsp;&nbsp; </td>
    </tr>
  </table>
<br>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
      <td nowrap align="center" width="4%">序号</td>
      <td width="8%" align="center" nowrap id=".name" >雇主</td>
      <td width="6%" height="24" align="center" nowrap id=".name" ><div align="center" orderBy="true">手机/固</div></td>
      <td width="16%" height="24" align="center" nowrap id=".phone" ><div align="center" orderBy="true">工人</div></td>
      <td width="11%" align="center" nowrap id=".title" ><div align="center" orderBy="true">手机/固</div></td>
      <td width="7%" align="center" nowrap id=".register" ><div align="center" orderBy="true">工资/月</div></td>
      <td width="31%" align="center" nowrap id=".register" ><strong>工作类型</strong></td>
      <td width="8%" align="center" nowrap id=".submit_date" ><strong>状态</strong></td>
      <td width="9%" align="center" nowrap id=".submit_date" ><strong>操作</strong></td>
    </tr>
    <c:forEach items="${sessionScope.ddgl}" var="dd" varStatus="s">
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td nowrap align="center" width="4%">${s.count} </td>
      <td align="center" nowrap>${dd.employer_name}</td>
      <td height="14" align="center" nowrap>${dd.e_telephone}</td>
      <td align="center" nowrap>${dd.worker_name}</td>
      <td align="center" nowrap>${dd.mobile_phone}</td>
      <td align="center" nowrap>${dd.pay}</td>
      <td align="center" nowrap>${dd.employment_type}</td>
      <td align="center" nowrap>${dd.status_}</td>
      <td align="center" nowrap><a href="${pageContext.request.contextPath}/Homemaking/employmentServlet?reqType=ddgl_ck&name=${dd.employer_name}">查看</a> <a href="${pageContext.request.contextPath}/Homemaking/employmentServlet?reqType=ddgl_xg&name=${dd.employer_name}&workername=${dd.worker_name}">修改</a></td>
      </c:forEach>
    </tr>

  </table>
<table width="96%" height="10"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td><input type="hidden" name="orderType" value="asc">
          <input type="hidden" name="orderFid" value=".submit_date">
          <table width="90%" style="font-size:12px;" border="0" cellspacing="3" cellpadding="2">
            <tr>
              <td nowrap width="45%" align="center"> 当前第1页 共5记录 分1页显示 </td>
              <td nowrap width="55%" align="right"><input type="hidden" name="currentPage" value="1">
                  <input type="hidden" name="paginationAction" value="">
                  <img src="../image/First_no.gif" alt="第一页" width="18" height="13" border="0">&nbsp&nbsp&nbsp <img src="../image/Previous_no.gif" alt="上一页" width="14" height="13" border="0">&nbsp&nbsp&nbsp <img src="../image/Next_no.gif" alt="下一页" width="14" height="13" border="0">&nbsp&nbsp&nbsp <img src="../image/Last_no.gif" alt="最后一页" width="18" height="13" border="0">&nbsp&nbsp&nbsp <a href="javascript:this.document.AwaitForm.submit()" oncontextmenu="return false" onClick="if(this.document.AwaitForm.pageSelect.value==''){ alert('页码必须输入');return false;}
 else {this.document.AwaitForm.paginationAction.value='gotoPage';}">前往</a>
                  <input type=text size='4' onlytype='int' onfocus='checkTextBoxInput()' name='pageSelect' value=''/>
                页 </td>
            </tr>
          </table>

      </td>
    </tr>
  </table>

</body>
</html>
