# ✅ Readme

## API 명세서

|    | HTTP Method | URL | Path Variable | Request Body(dto) | Respnse | 상태 |
|----|-------------|-----|---------------|-------------------|---------|------|
| 스케쥴 등록 | POST | /schedules | X | {<br> "name": "",<br> "do": "",<br> "password": "",<br> "created_date": "",<br> "edited_date": "" <br>} | {<br> "id": 1,<br> "name": "",<br> "do": "",<br> "password": "",<br> "created_date": "",<br> "edited_date": "" <br>} | 200: OK |
| 스케쥴 조회 | GET | /schedules/{id} | id_(Long) | X | {<br> "id": 1,<br> "name": "",<br> "do": "",<br> "password": "",<br> "created_date": "",<br> "edited_date": "" <br>} | 200: OK |
| 스케쥴 수정 | PUT,PATCH | /schedules/{id} | id_(Long) | {<br> "name": "",<br> "do": "",<br> "password": "",<br> "created_date": "",<br> "edited_date": "" <br>} | {<br> "name": "",<br> "do": "",<br> "password": "",<br> "created_date": "",<br> "edited_date": "" <br>} | 200: OK |
| 스케쥴 삭제 | DELETE | /schedules/{id} | id_(Long) | X |  | 200: OK |
| 스케쥴 목록 조회 | GET | /schedules | X | X | {<br> [<br> {<br> "id": 1,<br> "name": "",<br> "do": "",<br> "password": "",<br> "created_date": "",<br> "edited_date": "" <br>},<br> {<br> "id": 1,<br> "name": "",<br> "do": "",<br> "password": "",<br> "created_date": "",<br> "edited_date": "" <br>}<br> ]<br> } | 200: OK |

ERD link
https://www.erdcloud.com/d/66jBbjX5JAxZxk95Q
