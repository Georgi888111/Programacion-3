<%-- 
    Document   : index
    Created on : 05/10/2019, 19:52:24
    Author     : Georgi
--%>

<HTML>
<HEAD>
<TITLE>
Trabajo practico
</TITLE>
</HEAD>
<BODY>
<H1>Crea tabla</H1>
<%! int filas; %>
<%! int columnas; %>

<FORM action="pagina2.jsp" method="post">
 <P>Filas: <INPUT TYPE="TEXT" NAME="filas" SIZE="20" 
      VALUE="<%=filas%>" style="margin-left: 35px"></P>
 <P>Columnas: <INPUT TYPE="TEXT" NAME="columnas" SIZE="20" 
VALUE="<%=columnas%>"></P>
 <P><INPUT type="SUBMIT" VALUE="OK" NAME="boton2"></P>
 
</FORM>
</BODY>
</HTML>