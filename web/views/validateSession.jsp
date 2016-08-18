<%  if (session == null || session.getAttribute("user") == null) {  %>
        <jsp:forward page="index.jsp" />
<%  }  %>
