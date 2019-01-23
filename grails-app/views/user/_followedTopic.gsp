<g:if test="${followedTopic.size()!=0}">


    <h3>Followed-Topics:</h3>

    <table>
        <tr>
            <th>Name</th>
            <th>Owner</th>
            <th>Click for UnSubscribe</th>
        </tr>
        <g:each var="topic" in="${followedTopic}">
            <tr class="table-danger">
                <td>${topic.name}</td>
                <td>${topic.createdBy.username}</td>
                <td>
                    <g:link controller="subscription" action="unSubscribe" id="${topic.id}">
                        Unsubscribe
                    </g:link>
                </td>
            </tr>
        </g:each>
    </table>
</g:if>