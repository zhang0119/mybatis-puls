sql:
update t_user 
set user_name =? , email = ?  
where  is_deleted = 0 
and 
(user_name like ? and (age > ? or email is null));
---

