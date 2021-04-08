<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
${name}
<#if sex==1>
男
<#elseif sex==2>
女
<#else>
其他
</#if>
<#list users as user>
    ${user}
</#list>
</body>
</html>