<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insurance Report</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
        <div class="container">
        <h2>Insurance Report Generation</h2>
        <form:form method="post" modelAttribute="formBinder" action="/search">
            <div class="row">
                <!-- Plan Name Dropdown -->
                <div class="form-group col-md-6">
                    <label for="planName">Plan Name:</label>
                    <form:select path="planName" id="planName" class="form-control">
                        <form:option value="" label="- Select -" />
                        <form:options items="${planNames}" />
                    </form:select>
                </div>

                <!-- Plan Status Dropdown -->
                <div class="form-group col-md-6">
                    <label for="planStatus">Plan Status:</label>
                    <form:select path="planStatus" id="planStatus" class="form-control">
                        <form:option value="" label="- Select -" />
                        <form:option value="Approved" label="Approved" />
                        <form:option value="Denied" label="Denied" />
                        <form:option value="Terminated" label="Terminated" />
                    </form:select>
                </div>

                <!-- Gender Dropdown -->
                <div class="form-group col-md-6">
                    <label for="gender">Gender:</label>
                    <form:select path="gender" id="gender" class="form-control">
                        <form:option value="" label="- Select -" />
                        <form:option value="Male" label="male" />
                        <form:option value="Female" label="female" />
                        <form:option value="Others" label="other" />
                    </form:select>
                </div>

                <!-- Start Date Input -->
                <div class="form-group col-md-6">
                    <label for="startDate">Start Date:</label>
                    <form:input path="startDate" type="date" id="startDate" class="form-control" />
                </div>

                <!-- End Date Input -->
                <div class="form-group col-md-6">
                    <label for="endDate">End Date:</label>
                    <form:input path="endDate" type="date" id="endDate" class="form-control" />
                </div>
            </div>

            <!-- Submit Button -->
            <div class="form-group mt-3">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="/" class="btn btn-secondary">Reset</a>
            </div>
        </form:form>
    </div>
    <!-- Display "No Records Found" if the formResult is empty -->
<c:if test="${empty formResult}">
    <div class="mt-5" style="text-align: center;">
        <h3>No Records Found</h3>
    </div>
</c:if>
        <!-- Display the results in a table if any records exist -->
        <c:if test="${not empty formResult}">
            <h3 class="mt-5">Search Results</h3>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>CITIZEN ID</th>
                            <th>CITIZEN NAME</th>
                            <th>GENDER</th>
                            <th>PLAN NAME</th>
                            <th>PLAN STATUS</th>
                            <th>START DATE</th>
                            <th>END DATE</th>
                            <th>BENEFIT AMOUNT</th>
                            <th>DENIAL REASON</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="record" items="${formResult}">
                            <tr>
                                <td>${record.citizenId}</td>
                                <td>${record.citizenName}</td>
                                <td>${record.gender}</td>
                                <td>${record.planName}</td>
                                <td>${record.planStatus}</td>
                                <td>${record.planStartDate}</td>
                                <td>${record.planEndDate}</td>
                                <td>${record.benefitAmount}</td>
                                <td>${record.denialReason}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>

    </div>
    <hr>
    <div>
          <a href="/excel" class="btn btn-success">Excel</a>
          <a href="/pdf" class="btn btn-danger">PDF</a>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>