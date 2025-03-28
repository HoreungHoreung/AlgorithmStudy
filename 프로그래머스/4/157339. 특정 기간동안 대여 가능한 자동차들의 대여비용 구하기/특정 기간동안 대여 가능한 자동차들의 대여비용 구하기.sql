-- 코드를 입력하세요
WITH CAR_HISTORY AS (
SELECT DISTINCT C.CAR_ID, CAR_TYPE, DAILY_FEE 
FROM CAR_RENTAL_COMPANY_CAR C
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H ON C.CAR_ID = H.CAR_ID
WHERE C.CAR_TYPE IN ('세단', 'SUV') AND C.CAR_ID NOT IN (
SELECT H2.CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H2
WHERE H2.START_DATE <= '2022-11-30' AND H2.END_DATE >= '2022-11-01'))

SELECT CH.CAR_ID, CH.CAR_TYPE, ROUND((CH.DAILY_FEE * (100 - P.DISCOUNT_RATE) / 100) * 30) AS FEE
FROM CAR_HISTORY CH
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON CH.CAR_TYPE = P.CAR_TYPE AND DURATION_TYPE = '30일 이상'
WHERE (CH.DAILY_FEE * (100 - P.DISCOUNT_RATE) / 100) * 30 >= 500000 AND
(CH.DAILY_FEE * (100 - P.DISCOUNT_RATE) / 100) * 30 <= 2000000
ORDER BY FEE DESC, CH.CAR_TYPE ASC, CH.CAR_ID DESC;