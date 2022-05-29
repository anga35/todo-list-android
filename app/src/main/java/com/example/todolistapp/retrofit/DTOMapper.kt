package com.example.todolistapp.retrofit

import com.example.todolistapp.model.Task
import com.example.todolistapp.model.User
import com.example.todolistapp.utils.EntityMapper



class DTOMapper {

    class TaskDTOMapper : EntityMapper<TaskDTO, Task> {
        override fun mapToDomain(entity: TaskDTO): Task {
            return Task(
                id = entity.id,
                name = entity.name,
                createDate = entity.createDate,
                deadline = entity.deadline,
                isDone = entity.isDone

            )


        }
    }




    class UserDTOMapper : EntityMapper<UserDTO, User> {
        override fun mapToDomain(entity: UserDTO): User {
            return User(
                email = entity.email,
                fullname = entity.fullname,
                profilePicture = entity.profilePicture,
                tasks = entity.tasks

            )


        }
    }

}