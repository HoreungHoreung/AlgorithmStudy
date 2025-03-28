-- 코드를 입력하세요
SELECT U.USER_ID, U.NICKNAME, CONCAT(U.CITY, ' ', U.STREET_ADDRESS1, ' ', U.STREET_ADDRESS2) AS '전체주소', CONCAT(SUBSTRING(TLNO,1, 3), '-', SUBSTRING(TLNO, 4, 4), '-', SUBSTRING(TLNO, 8, 4)) AS '전화번호'
FROM USED_GOODS_USER U
WHERE U.USER_ID IN (
SELECT B.WRITER_ID
FROM USED_GOODS_BOARD B
GROUP BY B.WRITER_ID
HAVING COUNT(*) >= 3)
ORDER BY U.USER_ID DESC;