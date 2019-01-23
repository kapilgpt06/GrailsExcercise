
<h3>OtherUsers:</h3>

<table class="table">
    <thead class="thead-light">
    <tr class="table-dark">
        <th>Name</th>
        <th>EMAIL</th>
        <th>Topics</th>
    </tr>
    </thead>
    <tbody>
    <g:each var="user" in="${userList}">
        <tr class="table-danger">
            <td>${user.name}</td>
            <td>${user.username}</td>
            <td>${user.topics.name}</td>
        </tr>
    </g:each>
    </tbody>
</table>