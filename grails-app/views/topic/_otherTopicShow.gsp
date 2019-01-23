<g:if test="${otherTopicList.size()!=0}">


    <h3>Other-UserTopics:</h3>

    <table>
        <tr>
            <th>Name</th>
            <th>Owner</th>
            <th>Click for Subscribe</th>
        </tr>
        <g:each var="topic" in="${otherTopicList}">
            <tr class="table-danger">
                <td>${topic.name}</td>
                <td>${topic.createdBy.username}</td>
                <td>
                    <g:link controller="subscription" action="subscribe" id="${topic.id}">
                        subscribe
                    </g:link>
                </td>
            </tr>
        </g:each>
    </table>
</g:if>