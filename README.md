# API 명세서

| 기능       | Method | URI                           | RequestBody                                                                        | ResponseBody                                                                                                                                                               |
|----------|--------|-------------------------------|------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 일정 등록    | POST   | /api/plans                    | {<br/>"postedBy": "String", <br/>"title": "String", <br/>"content": "String"<br/>} | {<br/>"id": "Long", <br/>"postedBy": "String", <br/>"title": "String", <br/>"content": "String", <br/>"postedAt": "LocalDateTime", <br/>"updatedAt": "LocalDateTine"<br/>} |
| 일정 단건 조회 | GET    | /api/plans/{id}               | -                                                                                  | {<br/>"id": "Long", <br/>"postedBy": "String", <br/>"title": "String", <br/>"content": "String", <br/>"postedAt": "LocalDateTime", <br/>"updatedAt": "LocalDateTine"<br/>} |
| 일정 수정    | PUT    | /api/plans/{id}               | {<br/>"title": "String", <br/>"content": "String"<br/>}                            | {<br/>"id": "Long", <br/>"postedBy": "String", <br/>"title": "String", <br/>"content": "String", <br/>"postedAt": "LocalDateTime", <br/>"updatedAt": "LocalDateTine"<br/>} |
| 일정 삭제    | DELETE | /api/plans/{id}               | -                                                                                  | -                                                                                                                                                                          |
| 댓글 작성    | POST   | /api/plans/{id}/comments      | {<br/>"comment": "String", <br/>"commentedBy": "String"<br/>}                      | {<br/>"id": "Long", <br/>"comment": "String", <br/>"commentedBy": "String", <br/>"commentedAt": "LocalDateTime", <br/>"commentUpdatedAt": "LocalDateTine"<br/>}            |
| 댓글 단건 조회 | GET    | /api/plans/{id}/comments/{id} | -                                                                                  | {<br/>"id": "Long", <br/>"comment": "String", <br/>"commentedBy": "String", <br/>"commentedAt": "LocalDateTime", <br/>"commentUpdatedAt": "LocalDateTine"<br/>}            |
| 댓글 수정    | PUT    | /api/plans/{id}/comments/{id} | {<br/>"comment": "String"<br/>}                                                    | {<br/>"id": "Long", <br/>"comment": "String", <br/>"commentedBy": "String", <br/>"commentedAt": "LocalDateTime", <br/>"commentUpdatedAt": "LocalDateTine"<br/>}            |
| 댓글 삭제    | DELETE | /api/plans/{id}/comments/{id} | -                                                                                  | -                                                                                                                                                                          |
| 유저 등록    | POST   | /api/users                    | {<br/>"userName": "String", <br/>"email": "String", <br/>}                         | {<br/>"id": "Long", <br/>"userName": "String", <br/>"email": "String", <br/>"createdAt": "LocalDateTime", <br/>"fixedAt": "LocalDateTime"<br/>}                            |
| 유저 단건 조회 | GET    | /api/users/{id}               | -                                                                                  | {<br/>"id": "Long", <br/>"userName": "String", <br/>"email": "String", <br/>"createdAt": "LocalDateTime", <br/>"fixedAt": "LocalDateTime"<br/>}                            |
| 유저 전체 조회 | GET    | /api/users/                   | -                                                                                  | {<br/>"id": "Long", <br/>"userName": "String", <br/>"email": "String", <br/>"createdAt": "LocalDateTime", <br/>"fixedAt": "LocalDateTime"<br/>}                            |
| 유저 수정    | PUT    | /api/users/{id}               | {<br/>"userName": "String", <br/>"email": "String", <br/>}                         | {<br/>"id": "Long", <br/>"userName": "String", <br/>"email": "String", <br/>"createdAt": "LocalDateTime", <br/>"fixedAt": "LocalDateTime"<br/>}                            |
| 유저 삭제    | DELETE | /api/users/{id}               | -                                                                                  | -                                                                                                                                                                          |

<br/>

![planner_ERD.jpg](image/planner_ERD.jpg)



