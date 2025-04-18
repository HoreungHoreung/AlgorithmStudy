-- 코드를 작성해주세요
WITH MAX_PER_YEAR AS (
SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR,  MAX(SIZE_OF_COLONY) AS MAX_SIZE
FROM ECOLI_DATA
GROUP BY YEAR(DIFFERENTIATION_DATE))

SELECT YEAR(E.DIFFERENTIATION_DATE) AS YEAR, (Y.MAX_SIZE - E.SIZE_OF_COLONY) AS YEAR_DEV, ID
FROM ECOLI_DATA E
JOIN MAX_PER_YEAR Y ON YEAR(E.DIFFERENTIATION_DATE) = Y.YEAR
ORDER BY YEAR(DIFFERENTIATION_DATE), YEAR_DEV;