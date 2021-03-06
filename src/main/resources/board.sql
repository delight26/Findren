CREATE TABLE findren_write_01_board
(
   wr_id              int(11),
   wr_num             int(11) DEFAULT 0,
   wr_reply           varchar(10),
   wr_parent          int(11) DEFAULT 0,
   wr_is_comment      tinyint(4) DEFAULT 0,
   wr_comment         int(11) DEFAULT 0,
   wr_comment_reply   varchar(5),
   ca_name            varchar(255),
   wr_option          varchar(20),
   wr_subject         varchar(255),
   wr_content         text,
   wr_link1           text,
   wr_link2           text,
   wr_link1_hit       int(11) DEFAULT 0,
   wr_link2_hit       int(11) DEFAULT 0,
   wr_hit             int(11) DEFAULT 0,
   wr_good            int(11) DEFAULT 0,
   wr_nogood          int(11) DEFAULT 0,
   mb_id              varchar(20),
   wr_password        varchar(255),
   wr_name            varchar(255),
   wr_email           varchar(255),
   wr_homepage        varchar(255),
   wr_datetime        datetime DEFAULT '2000-04-04 00:00:00',
   wr_file            tinyint(4) DEFAULT 0,
   wr_last            varchar(19),
   wr_ip              varchar(255),
   wr_facebook_user   varchar(255),
   wr_twitter_user    varchar(255),
   wr_1               varchar(255),
   wr_2               varchar(255),
   wr_3               varchar(255),
   wr_4               varchar(255),
   wr_5               varchar(255),
   wr_6               varchar(255),
   wr_7               varchar(255),
   wr_8               varchar(255),
   wr_9               varchar(255),
   wr_10              varchar(255)
)