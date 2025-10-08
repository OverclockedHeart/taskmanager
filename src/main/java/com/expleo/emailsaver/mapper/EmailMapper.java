package com.expleo.emailsaver.mapper;

import org.mapstruct.Mapper;

import com.expleo.emailsaver.dto.EmailDTO;
import com.expleo.emailsaver.model.Email;
import com.expleo.emailsaver.dto.CreateEmailRequestDTO;

@Mapper(componentModel = "spring")
public interface EmailMapper {
    
    //DTO -> Entity
    Email toEntity(EmailDTO EmailDTO);
    Email createEmailToEntity(CreateEmailRequestDTO emailDTO);

    //Entity -> DTO
    EmailDTO toDto(Email email);
    CreateEmailRequestDTO createEmailToDTO(Email email);

}
