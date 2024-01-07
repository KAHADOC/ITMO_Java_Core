
drop table if exists sandbanks;
drop table if exists crew;
drop table if exists catch;
drop table if exists trips;
drop table if exists vessels;

create table if not exists vessels (
    id int primary key,
    name VARCHAR(255) unique NOT NULL,
    certificate VARCHAR(255) NOT NULL,
    type VARCHAR(255) not null,
	displacement int,
	manufactured date
);
create table if not exists trips (
    id int primary key,
    boat_name VARCHAR(255) NOT NULL,
	boat_id int,
	departure date,
	arrival date,
	FOREIGN KEY (boat_id) REFERENCES vessels (id)
	on delete restrict on update cascade
);
create table if not exists sandbanks (
    id INT primary key,
    name VARCHAR(255) NOT NULL,
	trip_id int,
	arrival date,
	departure date,
	quality VARCHAR(255),
	FOREIGN KEY (trip_id) REFERENCES trips (id)
	on delete restrict on update cascade
);
create table if not exists crew (
    id INT primary key,
    name VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	trip_id int,
	position VARCHAR(255) NOT NULL,
	FOREIGN KEY (trip_id) REFERENCES trips (id)
	on delete restrict on update cascade
);
create table if not exists catch (
    id INT primary key,
    name VARCHAR(255) NOT NULL,	
	trip_id int,
	weight int default 0,
	FOREIGN KEY (trip_id) REFERENCES trips (id)
	on delete restrict on update cascade
);
insert into vessels(id, name, certificate, type, displacement, manufactured)
values
	(111, 'Fishy Business', 'LA-2791-GM', 'motorboat', 80, '2007-11-16'),
	(222, 'The Codfather', 'HHJ98986LLKJ', 'trawler', 450, '2020-03-21'),
	(333, 'Shark Bait', 'DCVVV324ERT', 'catamaran', 148, '2016-03-08'),
	(444, 'Old Buoy', '3344DFZ67778', 'gillnetter', 320, '1500-5-30'),
	(555, 'Seasick', '3ff-56-EZc67', 'yacht', 270, '2022-02-24'),
	(666, 'Jawesome', 'DFGTHHH', 'skiff', 350, '2021-12-31'),
	(777, 'Shelly', 'cd1223', 'convertible', 600, '2023-11-30');
--	returning *;
insert into trips(id, boat_name, boat_id, departure, arrival)
values
	(1, 'Fishy Business', 111, '2007-11-16', '2007-11-26'),
	(2, 'The Codfather', 222, '2020-03-07', '2020-03-21'),
	(3, 'Shark Bait', 333, '2016-02-09', '2016-03-08'),
	(4, 'Old Buoy', 444, '2015-05-13', '2015-5-30'),
	(5, 'Seasick', 555, '2022-02-4', '2022-02-24'),
	(6, 'Jawesome', 666, '2021-12-11', '2021-12-31'),
	(7, 'Shelly', 777, '2023-11-17', '2023-11-30'),
	(8, 'Fishy Business', 111, '2023-5-16', '2007-7-2');
--	returning *;
insert into crew(id, name, address, trip_id, position)
values
	(1, 'Smock Bellew', '124 Rodeo Drive, Los Angeles, CA', 1, 'Captain'),
	(2, 'Some Chap', 'Hobo, Street Bum', 2, 'Helper'),
	(3, 'Other Dude', '13442 Yonge Str, Toronto, ON, Canada', 3, 'Skipper'),
	(4, 'Some Chap', 'Hobo, Street Bum', 3, 'Botswain'),
	(5, 'Other Dude', '13442 Yonge Str, Toronto, ON, Canada', 4, 'Captain'),
	(6, 'Poor Sod', 'Times Square subway entrance', 4, 'Pullman'),
	(7, 'Smock Bellew', '124 Rodeo Drive, Los Angeles, CA', 4, 'Janitor'),
	(8, 'Some Chap', 'Hobo, Street Bum', 4, 'Skipper');
--	returning *;
insert into catch(id, name, trip_id, weight)
values
	(1, 'Cod', 1, 125),
	(2, 'Tuna', 2, 18),
	(3, 'Cambala', 3, 177),
	(4, 'Salmon', 3, 193),
	(5, 'Salmon', 4, 332),
	(6, 'Cod', 4, 225),
	(7, 'Tuna', 4, 700),
	(8, 'Shark', 4, 40);
--	returning *;
insert into sandbanks(id, name, trip_id, arrival, departure, quality)
values
	(1, 'Mumbasa Place', 1, '2007-11-16', '2007-11-26', 'Awful'),
	(2, 'Cape Cod', 2, '2020-03-07', '2020-03-12', 'Atrocious'),
	(3, 'Oyako Sandbank', 2, '2016-02-09', '2016-03-08', 'Mediocre'),
	(4, 'Old Bay', 3, '2016-02-09', '2016-02-28', 'Bad'),
	(5, 'Navy Base', 3, '2016-03-04', '2016-03-07', 'Normal'),
	(6, 'Cape Cod', 4, '2015-05-15', '2015-5-17', 'Awful'),
	(7, 'Oyako Sandbank', 4, '2015-05-19', '2015-5-24', 'Normal'),
	(8, 'Old Bay', 4, '2015-05-25', '2015-5-28', 'Bad');
--	returning *;

--для каждого катера вывести даты выхода в море с указанием улова
select boat_name, departure, arrival, sum(weight) as total_catch from catch c 
join trips on trips.id = c.trip_id
group by boat_name, departure, arrival
order by boat_name, departure;

--для каждого катера вывести количество рейсов
select boat_name, count(boat_name) as total_trips from trips
group by boat_name
order by boat_name;

--вывести список катеров, которые получили улов выше заданного значения
select boat_name, sum(weight) as total_catch from catch c 
join trips on trips.id = c.trip_id
group by boat_name
having sum(weight) > 300
order by boat_name;

--вывести список сортов рыбы и для каждого сорта список рейсов 
--с указанием даты выхода и возвращения, количества улова
select c.name, trips.id as trips, departure, arrival, weight from catch c 
join trips on trips.id = c.trip_id
order by c.name;