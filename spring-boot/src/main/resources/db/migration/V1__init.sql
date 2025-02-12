    create table member (
        member_key int auto_increment primary key,
        member_code varchar(50) not null,
        first_name varchar(50) not null,
        last_name varchar(50) not null,
        constraint unique_member_code unique (member_code)
    );
