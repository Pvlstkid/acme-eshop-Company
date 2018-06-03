SELECT SUM( a.QUANTITY) as SOLD, a.TITLE FROM USER_ORDER
LEFT JOIN ( SELECT PRODUCT.TITLE,SUM(QUANTITY) as QUANTITY, ORDER_ID
FROM PRODUCT_ITEM, PRODUCT
WHERE 1=1
AND ORDER_ID IS NOT NULL
AND PRODUCT.PRODUCT_ID = PRODUCT_ITEM.PRODUCT_ID
GROUP BY PRODUCT.TITLE,ORDER_ID) a
WHERE 1=1
AND a.ORDER_ID = USER_ORDER.ORDER_ID
AND USER_ORDER.ORDER_STATUS = 'COMPLETED'
GROUP BY a.TITLE
ORDER BY SUM( a.QUANTITY) DESC