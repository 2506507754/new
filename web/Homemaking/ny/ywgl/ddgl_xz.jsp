<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<style type="text/css">
    <!--
    .STYLE2 {font-size: 16px}
    -->
</style>
<head>
    <title>Untitled Document</title>
    <script type="text/javascript" src="../tdp/js/validator.js"></script>
    <script type="text/javascript" src="../tdp/js/public.js"></script>
    <script type="text/javascript" src="../javascript/handleArchive.js"></script>
    <script src="../js/jquery-3.4.1.min.js"></script>
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

        function emp() {
            var name = $("#e_name").val();
            $.get('${pageContext.request.contextPath}/Homemaking/employmentServlet',{reqType:"select",check:"employer",name:name},function (date) {
                if (date.E.gender=="男") {
                    document.getElementById("radio13").checked =false;
                    document.getElementById("radio12").checked =true;
                }else if ((date.E.gender=="女")) {
                    document.getElementById("radio13").checked =true;
                    document.getElementById("radio12").checked =false;
                }
                $("#textarea001").val(date.E.age);
                $("#textarea2").val(date.E.nation);
                $("#textarea50").val(date.E.hometown)
                $("#textarea401").val(date.E.education);
                $("#textarea301").val(date.E.idnumber);
                $("#textarea12").val(date.E.address);
                $("#textarea220").val(date.E.telephone);
                $("#textarea22").val(date.E.house);
                $("#textarea100").val(date.E.profession);
                $("#textarea60").val(date.E.worker_unit);
                $("#textarea11").val(date.E.min_pay);
                $("#textarea23").val(date.E.max_pay);
                $("#textarea13").val(date.E.service_address);
                $("#textarea14").val(date.E.home_current_address);
                $("#textarea15").val(date.E.home_people_number);
                $("#textarea16").val(date.E.home_service);
                $("#textarea17").val(date.E.home_size);
                $("#textarea18").val(date.E.home_food);
                $("#textarea19").val(date.E.home_other);
                $("#employer_number").val(date.E.employer_number)
            },"json")
        }

        function worker() {
            var name = $("#w_name").val();
            $.get('${pageContext.request.contextPath}/Homemaking/employmentServlet',{reqType:"select",check:"worker",name:name},function (date) {
                if (date.W.gender=="男") {
                    document.getElementById("radio2").checked =false;
                    document.getElementById("radio").checked =true;
                }else if ((date.W.gender=="女")) {
                    document.getElementById("radio2").checked =true;
                    document.getElementById("radio").checked =false;
                }

                if (date.W.gender=="男") {
                    document.getElementById("radio2").checked =false;
                    document.getElementById("radio").checked =true;
                }else if ((date.W.gender=="女")) {
                    document.getElementById("radio2").checked =true;
                    document.getElementById("radio").checked =false;
                }
                $("#textarea").val(date.W.worker_number);
                $("#textarea4").val(date.W.company_number);
                $("#textarea40").val(date.W.idnumber);
                $("#textarea3").val(date.W.birthday);
                $("#textarea5").val(date.W.age);
                $("#textarea8").val(date.W.height);
                $("#textarea61").val(date.W.mobile_phone);
                $("#textarea6").val(date.W.telephone);
                $("#textarea91").val(date.W.work_type);
                $("#textarea7").val(date.W.work_time);
                $("#textarea10").val(date.W.disadvantage);
                $("#select").val(date.W.status)
            },"json")

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

<form action="${pageContext.request.contextPath}/Homemaking/employmentServlet?reqType=ddxz" method="post">
<table width="96%" height="80" border="0" align="center" cellpadding="0" cellspacing="0" >
    <tr>
        <td width="67%" height="40" align="center" nowrap class="MENU_line1">家政服务消费订单</td>
    </tr>
    <tr>
        <td align="right" nowrap class="MENU_line1 STYLE2">订单编号：GZ20006300223</td>
    </tr>
</table>

<p>雇主：<br>
</p>
<input type="hidden" name="employer_number" id="employer_number" value="">
<table width="94%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
    <tr>
        <td width="10%" align="right" bgcolor="#FFFFFF">姓名：</td>
        <td width="13%" bgcolor="#FFFFFF">

            <select id="e_name" name="select" onchange="emp()">
                <option>请选择</option>
                <c:forEach items="${e_name}" var="e">
                    <option>${e}</option>
                </c:forEach>
            </select>
        </td>
        <td width="12%" align="right" bgcolor="#FFFFFF">性别：</td>
        <td width="17%" bgcolor="#FFFFFF">
            <input type="radio" name="radio" id="radio12" value="男" >
            男
            <input type="radio" name="radio" id="radio13" value="女" >
            女</td>
        <td width="10%" align="right" bgcolor="#FFFFFF">年龄：</td>
        <td width="13%" bgcolor="#FFFFFF"><input name="textarea" type="text" id="textarea001" value="" size="15" class="pi"></td>
        <td width="10%" align="right" bgcolor="#FFFFFF">民族：</td>
        <td width="15%" bgcolor="#FFFFFF"><input name="textarea2" type="text" id="textarea2" value="" size="15" class="pi"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="#FFFFFF">籍贯：</td>
        <td bgcolor="#FFFFFF"><input name="textarea5" type="text" id="textarea50" value="" size="15" class="pi"></td>
        <td align="right" bgcolor="#FFFFFF">学历：</td>
        <td bgcolor="#FFFFFF"><input name="textarea4" type="text" id="textarea401" value="" size="15" class="pi"></td>
        <td align="right" bgcolor="#FFFFFF">身份证号码：</td>
        <td colspan="3" bgcolor="#FFFFFF"><input name="textarea3" type="text" id="textarea301" value="" size="20" class="pi"></td>
    </tr>
    <tr>
        <td align="right" nowrap bgcolor="#FFFFFF">户口所在地：</td>
        <td colspan="7" bgcolor="#FFFFFF"><input name="textarea12" type="text" id="textarea12" value="" size="65" class="pi"></td>
    </tr>
    <tr>
        <td align="right" nowrap bgcolor="#FFFFFF">手机：</td>
        <td align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea220" value="" size="15" class="pi"></td>
        <td align="right" nowrap bgcolor="#FFFFFF">住宅：</td>
        <td align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea22" value="" size="15" class="pi"></td>
        <td align="right" bgcolor="#FFFFFF">职业：</td>
        <td colspan="3" bgcolor="#FFFFFF"><input name="textarea8" type="text" id="textarea100" value="" size="20" class="pi"></td>
    </tr>
    <tr>
        <td align="right" nowrap bgcolor="#FFFFFF">工作单位：</td>
        <td colspan="7" bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea60" value="" size="65" class="pi"></td>
    </tr>
    <tr>
        <td align="right" nowrap bgcolor="#FFFFFF">接受工资：</td>
        <td colspan="2" align="left" bgcolor="#FFFFFF">从
            <input name="textarea11" type="text" id="textarea11" value="" size="8" class="pi">
            到
            <input name="textarea23" type="text" id="textarea23" value="" size="8" class="pi"></td>
        <td align="left" bgcolor="#FFFFFF">&nbsp;</td>
        <td align="right" bgcolor="#FFFFFF">介绍费：</td>
        <td colspan="3" bgcolor="#FFFFFF"><input name="fee" type="text" id="textarea24" value="" size="20" class="pi"></td>
    </tr>


    <tr>
        <td colspan="2" align="right" bgcolor="#FFFFFF">服务处所（地址）：</td>
        <td colspan="6" bgcolor="#FFFFFF"><input name="textarea13" type="text" id="textarea13" value="" size="44" class="pi"></td>
    </tr>
    <tr>
        <td rowspan="6" align="center" bgcolor="#FFFFFF">家<br>
            庭<br>
            资<br>
            料</td>
        <td align="right" bgcolor="#FFFFFF">居住地址：</td>
        <td colspan="6" align="left" bgcolor="#FFFFFF"><input name="textarea14" type="text" id="textarea14" value="" size="44" class="pi"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="#FFFFFF">家庭人数：</td>
        <td colspan="6" bgcolor="#FFFFFF"><input name="textarea15" type="text" id="textarea15" value="" size="44" class="pi"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="#FFFFFF">服务内容：</td>
        <td colspan="6" bgcolor="#FFFFFF"><input name="textarea16" type="text" id="textarea16" value="" size="44" class="pi"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="#FFFFFF">房屋面积：</td>
        <td colspan="6" bgcolor="#FFFFFF"><input name="textarea17" type="text" id="textarea17" value="" size="44" class="pi"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="#FFFFFF">饮食习惯：</td>
        <td colspan="6" bgcolor="#FFFFFF"><input name="textarea18" type="text" id="textarea18" value="" size="44" class="pi"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="#FFFFFF">其他：</td>
        <td colspan="6" bgcolor="#FFFFFF"><input name="textarea19" type="text" id="textarea19" value="" size="44" class="pi"></td>
    </tr>
    <tr>

        <td colspan="8" align="left" bgcolor="#FFFFFF" height="33"></td>
    </tr>
    
    <tr>
        <td colspan="8" align="left" nowrap bgcolor="#FFFFFF">工人：</td>

    </tr>
    <tr>
        <td colspan="8"  align="left" bgcolor="#FFFFFF">
            <table height="236" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                <tr>
                    <td width="88" height="23" align="right" bgcolor="#FFFFFF">员工编号：</td>
                    <td width="221" bgcolor="#FFFFFF"><input name="worker_number" type="text" id="textarea" value="" size="30" class="pi"></td>
                    <td width="75" align="right" bgcolor="#FFFFFF">所属公司：</td>
                    <td width="258" bgcolor="#FFFFFF"><input name="company_number" type="text" id="textarea4" value="" size="30" class="pi"></td>
                    <td width="87" rowspan="8" align="center" valign="middle" bgcolor="#FFFFFF"></td>
                </tr>
                <tr>
                    <td height="23" align="right" bgcolor="#FFFFFF">姓名：</td>
                    <td bgcolor="#FFFFFF">
                        <select id="w_name" name="w_name" onchange="worker()">
                            <option>请选择</option>
                            <c:forEach items="${w_name}" var="w">
                                <option>${w}</option>
                            </c:forEach>

                        </select></td>
                    <td align="right" bgcolor="#FFFFFF">性别：</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="radio" id="radio" value="男">
                        男
                        <input type="radio" name="radio" id="radio2" value="女">
                        女</td>
                </tr>
                <tr>
                    <td height="23" align="right" bgcolor="#FFFFFF">身份证号码：</td>
                    <td bgcolor="#FFFFFF"><input name="textarea40" type="text" id="textarea40" value="" size="30" class="pi"></td>
                    <td height="23" align="right" bgcolor="#FFFFFF">出生年月：</td>
                    <td bgcolor="#FFFFFF"><input name="textarea3" type="text" id="textarea3" value="" size="30" class="pi"></td>
                </tr>
                <tr>
                    <td align="right" bgcolor="#FFFFFF">年龄：</td>
                    <td bgcolor="#FFFFFF"><input name="textarea5" type="text" id="textarea5" value="" size="30" class="pi"></td>
                    <td height="23" align="right" bgcolor="#FFFFFF">身高：</td>
                    <td bgcolor="#FFFFFF"><input name="textarea8" type="text" id="textarea8" value="" size="30" class="pi"></td>
                </tr>
                <tr>
                    <td height="31" align="right" bgcolor="#FFFFFF">手机：</td>
                    <td bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea61" value="" size="30" class="pi"></td>
                    <td align="right" bgcolor="#FFFFFF">电话：</td>
                    <td bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea6" value="" size="30" class="pi"></td>
                </tr>
                <tr>
                    <td height="23" align="right" bgcolor="#FFFFFF">工种：</td>
                    <td bgcolor="#FFFFFF"><input name="textarea9" type="text" id="textarea91" value="" size="30" class="pi"></td>
                    <td align="right" bgcolor="#FFFFFF">从业时间：</td>
                    <td bgcolor="#FFFFFF"><input name="textarea7" type="text" id="textarea7" value="" size="30" class="pi"></td>
                </tr>

                <tr>
                    <td height="23" align="right" bgcolor="#FFFFFF">缺陷：</td>
                    <td bgcolor="#FFFFFF"><input name="textarea10" type="text" id="textarea10" value="" size="30" class="pi"></td>
                    <td align="right" bgcolor="#FFFFFF">教育程度：</td>
                    <td bgcolor="#FFFFFF"><input type="radio" name="radio" id="radio30" value="radio" />
                        大专&nbsp;
                        <input type="radio" name="radio" id="radio31" value="radio" />
                        高中&nbsp;
                        <input type="radio" name="radio" id="radio32" value="radio" />
                        初中&nbsp;
                        <input type="radio" name="radio" id="radio33" value="radio" />
                        小学&nbsp; </td>
                </tr>

            </table>
        </td>
    </tr>
    <tr>
        <td align="right" nowrap bgcolor="#FFFFFF">雇用类型：</td>
        <td colspan="7" bgcolor="#FFFFFF">
            <input type="checkbox" name="e_type" id="checkbox40" value="月嫂" />
            月嫂
            &nbsp;
            <input type="checkbox" name="e_type" id="checkbox41" value="保姆"/>
            保姆&nbsp;&nbsp;
            <input type="checkbox" name="e_type" id="checkbox42" value="钟点" />
            钟点&nbsp;&nbsp;
            <input type="checkbox" name="e_type" id="checkbox43" value="厨嫂" />
            厨嫂
            <input type="checkbox" name="e_type" id="checkbox44" value="清洁工"/>
            清洁工
            &nbsp;
            <input type="checkbox" name="e_type" id="checkbox45" value="护工"/>
            护工&nbsp;&nbsp;
            <input type="checkbox" name="e_type" id="checkbox46" value="早教"/>
            早教
            &nbsp;&nbsp;
            <input type="checkbox" name="e_type" id="checkbox47" value="家教"/>
            家教
            &nbsp;&nbsp;
            <input type="checkbox" name="e_type" id="checkbox48" value="高级管家"/>
            高级管家<br>
            备注：
            <input name="textarea9" type="text" id="textarea9" value="" size="40" class="pi"></td>
    </tr>
    <tr>
        <td align="right" colspan="8" height="33" nowrap bgcolor="#FFFFFF"></td>
    </tr>
    <tr>
        <td align="right" nowrap bgcolor="#FFFFFF">经办人：</td>
        <td align="left" bgcolor="#FFFFFF"><input name="manager_number" type="text" id="textarea201" value="" size="14" class="pi"></td>
        <td align="right" bgcolor="#FFFFFF">工资:</td>
        <td align="left" bgcolor="#FFFFFF"><input name="pay" type="text" id="textarea21" value="" size="14" class="pi"></td>
        <td align="right" bgcolor="#FFFFFF">订单有效期:</td>
        <td align="left" bgcolor="#FFFFFF"><input name="textarea500" type="text" id="textarea27" value="" size="14" class="pi"></td>
        <td align="right" bgcolor="#FFFFFF">状态：</td>
        <td align="left" bgcolor="#FFFFFF"><span class="text">
        <select name="status" id="select" class="input">
          <option>请选择</option>
          <option selected>未成交</option>
          <option>已成交</option>
          <option>在别处成交</option>
          <option>已取消</option>
      </select>
      </span></td>
    </tr>
</table>
<table width="96%" height="63" border="0" align="center" cellpadding="0" cellspacing="0" >
    <tr>
        <td width="67%" height="63" align="center" nowrap class="text">
            <input type="submit" name="searchbtn3" value="保  存" class="button_new" onClick="javascript:alert('保存成功！')">
            <input type="button" name="searchbtn3" value="返  回" class="button_new"onClick="javascript:location.href='${pageContext.request.contextPath}/Homemaking/employmentServlet?reqType=query'" >
            <input type="hidden" name="mod" value="no">
            &nbsp;&nbsp; </td>
    </tr>
</table>
</form>

</body>
</html>

