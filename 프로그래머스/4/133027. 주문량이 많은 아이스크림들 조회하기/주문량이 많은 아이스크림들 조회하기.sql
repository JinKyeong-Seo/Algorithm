SELECT FLAVOR
FROM (SELECT *
      FROM FIRST_HALF
      UNION
      SELECT *
      FROM JULY)
GROUP BY FLAVOR
ORDER BY SUM(TOTAL_ORDER) desc
FETCH FIRST 3 ROWS ONLY;