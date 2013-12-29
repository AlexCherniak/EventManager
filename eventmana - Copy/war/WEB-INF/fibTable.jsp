<%@ page import="backend.example.project.server.*" %>
<table>
<tr><td>מספר</td><td>מספר פיבונא'צי</td></tr>

<% for (int i=0; i<10; i++) { %>
    <tr><td>
    <%= i %>
    </td>
    <td>
    <%= Fib.getInstance().getFibNumber(i) %>
    </td></tr>
<% } %>
</table>