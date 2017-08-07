<!DOCTYPE html>
<%@include file="template/head.jsp"%>
<body>
<%@include file="template/header.jsp"%>
<%@include file="template/nav.jsp"%>
<div class="container">

    <div class="item-details">
        <table>
            <th><img src="${item.getIcon()}"/>${item.getName()}</th>
            <tr><td>Description</td><td>${item.getDescription()}</td></tr>
            <tr><td>Item Type</td><td>${item.getType()}</td></tr>
            <tr><td>Level</td><td>${item.getLevel()}</td></tr>
            <tr><td>Rarity</td><td>${item.getRarity()}</td></tr>
            <tr><td>Binding</td><td>${item.getFlags().toString()}</td></tr>
            <tr><td>Game Types</td><td>${item.getGameTypes()}</td></tr>
            <tr><td>Restrictions</td><td>${item.getRestrictions().toString()}</td></tr>
            <tr><td>Chat Link</td><td>${item.getChatLink()}</td></tr>
        </table>
    </div>

    <div class="item-recipe">
        <%@include file="template/item-recipe-tree.jsp"%>
    </div>





</div>
<%@include file="template/footer.jsp"%>
</body>
</html>