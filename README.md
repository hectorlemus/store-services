# store-services

#### Servicios

- ``products``: CRUD para catalogo de productos

- ``sales``: Gestiona venta de productos

<hr/>

#### Generalidades

- El desarrollo se realizo en un ambiente linux, por ello, para la base de datos se utilizo ``PostgreSQL``.

- Se agregra el archivo de ``docker-compose.yml`` para levantar el contenedor de postgresql

<hr/>

#### Consultas

- Consulta para obtener reporte de venta por dia y por producto, sumando la cantidad de productos vendidos 

```
select
s.day,
s.name,
sum(s.quantity) 
from (
	select 
	date_trunc('day', s.created_at) "day",
	p.name, 
	sp.quantity 
	from sale s 
	inner join sold_product sp on (s.id = sp.sale_id)
	inner join product p on (p.id = sp.product_id)
	where s.created_at between '2022-07-18 15:58:34.771' and '2022-07-21 15:58:34.771'
) as s
group by (s.day, s.name)
order by (s.day, s.name) asc
```

- Consulta para obtener reporte de venta por producto, sumando la cantidad de productos vendidos 

```
select 
p.name, 
sum(sp.quantity) 
from sale s 
inner join sold_product sp on (s.id = sp.sale_id)
inner join product p on (p.id = sp.product_id)
where s.created_at between '2022-07-18 15:58:34.771' and '2022-07-19 15:58:34.771'
group by (p.name)
order by (p.name) asc
```