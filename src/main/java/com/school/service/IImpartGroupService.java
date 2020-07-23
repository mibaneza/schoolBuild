package com.school.service;

import java.util.List;

import com.school.entity.ImpartGroup;
import com.school.exception.SchoolException;
import com.school.message.request.ImpartGroupForm;

public interface IImpartGroupService {
	public String createImpartGroupProfe(ImpartGroupForm impartGroupForm) throws SchoolException;
	public String createImpartGroupStude(ImpartGroupForm impartGroupForm) throws SchoolException;
	public List<ImpartGroup> findAllImpartGroup() throws SchoolException;
	public ImpartGroup findbyImpartGroup(Long id) throws SchoolException;
	public ImpartGroup updateImpartGroup(ImpartGroupForm impartGroupForm, Long id) throws SchoolException;
    public String deleteImpartGroup(Long id) throws SchoolException;
}
