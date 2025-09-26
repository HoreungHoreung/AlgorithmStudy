SELECT H.flavor
FROM FIRST_HALF H JOIN JULY J ON H.flavor = J.flavor
GROUP BY H.flavor
ORDER BY SUM(H.total_order) + SUM(J.total_order) DESC
LIMIT 3;