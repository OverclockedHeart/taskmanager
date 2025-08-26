CREATE TYPE public.task_priority AS ENUM ('LOW', 'MEDIUM', 'HIGH');
CREATE TYPE public."task_status" AS ENUM ('TODO', 'IN_PROGRESS', 'DONE');
CREATE TABLE public.users (
    id bigserial NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    created_at timestamp,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT users_email_key UNIQUE (email)
);
CREATE TABLE public.tasks (
    id bigserial NOT NULL,
    title character varying(255),
    description text,
    status task_status NOT NULL,
    priority task_priority NOT NULL,
    due_date date,
    user_id bigint,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT tasks_pkey PRIMARY KEY (id),
    CONSTRAINT tasks_user_id_fkey FOREIGN KEY (user_id) REFERENCES users (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);