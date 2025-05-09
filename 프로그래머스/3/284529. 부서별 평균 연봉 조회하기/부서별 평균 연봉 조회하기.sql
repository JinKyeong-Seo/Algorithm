SELECT DEPT_ID, (SELECT DEPT_NAME_EN
                 FROM HR_DEPARTMENT D
                 WHERE E.DEPT_ID = D.DEPT_ID) DEPT_NAME_EN, ROUND(AVG(SAL)) AVG_SAL
FROM HR_EMPLOYEES E
GROUP BY DEPT_ID
ORDER BY AVG_SAL desc;