<g:if test="${myTopicList.size()!=0}">

    <h3>myTopics:</h3>

    <table>
        <tr>
            <th>Name</th>
        </tr>
        <g:each var="topic" in="${myTopicList}">
            <tr class="table-danger">
                <td>${topic.name}</td>
            </tr>
        </g:each>
    </table>
</g:if>