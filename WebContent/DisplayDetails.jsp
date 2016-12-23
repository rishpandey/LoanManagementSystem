<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.ArrayList, com.rprt.lms.beans.Loan, java.util.Iterator"%>
<!DOCTYPE html>
<html class="full" lang="en">
<!-- Make sure the <html> tag is set to the .full CSS class. Change the background image in the full.css file. -->

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<title>Tanya Bank Loan</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/the-big-picture.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style type="text/css">
body {
	font-family: 'Montserrat', sans-serif;
}

th,td {
	padding: 5px;
}

#partialField{
	visibility:hidden;
}
</style>

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-bottom"
		role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Home</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="emi.html">EMI Calculator</a></li>
					<li><a href="ratesTable.html">Interest Rates</a></li>
					<li><a href="support.html">Support</a></li>
					<li><a href="eligible.html">Check Eligibility</a></li>
					<li><a href="terms.html">Terms and Conditions</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout.jsp">Logout</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-sm-12">
				<h1>Account Summary</h1>
				<table cellpadding="10">
					<tr>
						<th>LoanFile Number</th>
						<th>Loan Type</th>
						<th>Loan Tenure</th>
						<th>EMI</th>
						<th>Interest Rate</th>
						<th>Remaining Loan Amount</th>
						<th>Sanction Date</th>
						<th>Pay Loan</th>
					</tr>

					<%
						ArrayList<Loan> list = (ArrayList)session.getAttribute("list"); 
						Iterator<Loan> itr = list.iterator();
						int i = 0;
						while(itr.hasNext()){
						Loan loan=itr.next();
					%>
					<tr>
						<td><%=loan.getLoanFileNumber()%></td>
						<td><%=loan.getLoanType()%></td>
						<td><%=loan.getLoanTenure()%></td>
						<td><%=loan.getEMI()%></td>
						<td><%=loan.getInterestRate()%></td>
						<td><%=loan.getLoanAmount()%></td>
						<td><%=loan.getDate()%></td>
						<td><form action="payment.html"><button type="submit" value="<%= i %>">Pay!</button></form></td>
					</tr>
				<%
					i++;}
				%>
				
				</table>
				
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
