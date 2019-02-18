<html>

<body>
<h2>
Spring REST Demo. Welcome.
</h2>

<!-- a href="test/hello">Hello. This links to hello world test.</a-->
<!-- This is if I want to use the full path for the href -->
<a href="${pageContext.request.contextPath }/test/hello">Hello. This links to hello world test.</a>
<br>
<a href="${pageContext.request.contextPath }/api/students">return students</a>
</body>

</html>