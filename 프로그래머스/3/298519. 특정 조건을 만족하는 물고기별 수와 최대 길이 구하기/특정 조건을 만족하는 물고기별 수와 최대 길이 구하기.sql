-- 코드를 작성해주세요


SELECT count(*) as FISH_COUNT, max(length) as MAX_LENGTH, FISH_TYPE
FROM FISH_INFO
GROUP BY fish_type 
HAVING AVG(length) >= 33
ORDER BY fish_type ASC;