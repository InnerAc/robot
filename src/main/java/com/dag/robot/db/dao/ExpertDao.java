package com.dag.robot.db.dao;

import java.util.List;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Field;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.Topic;
import com.dag.robot.web.bean.ExpertForCheck;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.Page;

public interface ExpertDao {
	
	/**
	 * 增加专家信息
	 * @param expert 专家信息
	 */
	public void addExpert(Expert expert);
	
	/**
	 * 更新专家信息
	 * @param expert 专家信息
	 */
	public void updateExpert(Expert expert);
	
	/**
	 * 根据姓名检索专家
	 * @param name 专家姓名
	 */
	public List<Expert> getByName(String name);
	
	/**
	 * 根据id检索专家
	 * @param expertId 专家id
	 */
	public Expert getById(int expertId);
	
	/**
	 * 删除专家信息
	 * @param expert 专家
	 * 	 */
	public void deleteExpert(Expert expert);
	
	/**
	 * 增加专家相关领域
	 * @param expert 专家
	 * @param field  领域
	 * @param weight 权值
	 */
	public void addField(Expert expert, Field field, int weight);
	
	/**
	 * 增加专家相关话题
	 * @param expert 专家
	 * @param topic 话题
	 * @param weight
	 */
	public void addTopic(Expert expert, Topic topic, int weight);
	
	/**
	 * 增加专家论文信息
	 * @param expert 专家
	 * @param paper 论文
	 * @param authorNum 作者次序
	 */
	public void addPaper(Expert expert, Paper paper, int authorOrder);
	
	/**
	 * 增加专家专利信息
	 * @param expert 专家
	 * @param patent 专利
	 * @param authorOrder 作者次序
	 */
	public void addPatent(Expert expert, Patent patent, int authorOrder);
	
	/**
	 * 增加专家所属组织信息
	 * @param expert 专家
	 * @param orgnization 组织
	 * @param job 工作
	 */
	public void addOrgnization(Expert expert, Orgnization orgnization, String job);
	
	/**
	 * 检索专家领域信息
	 * @param expertId 专家id
	 * @return 领域List
	 */
	public List<Field> getFields(int expertId);
	
	/**
	 * 检索专家话题信息
	 * @param expertId 专家id
	 * @return 话题List
	 */
	public List<Topic> getTopics(int expertId);
	
	/**
	 * 检索专家论文信息
	 * @param expertId 专家id
	 * @return 论文List
	 */
	public List<Paper> getPapers(int expertId);
	
	/**
	 * 检索专家专利信息
	 * @param expertId 专家id
	 * @return 专利List
	 */
	public List<Patent> getPatents(int expertId);
	
	/**
	 * 检索专家组织信息
	 * @param expertId 专家id
	 * @return 组织List
	 */
	public Orgnization getOrgnization(int expertId);
	
	/**
	 * 分页
	 * @param pageSize 每页条数
	 * @param currenPage 当前页码
	 * @return 
	 */
	public Page<ExpertForList> page(int pageSize, int currenPage);
	
	/**
	 * 名字查重
	 * @param expertName 专家名字
	 * @return
	 */
	public List<ExpertForCheck> check(String expertName);
	
	/**
	 * 查询同一个专家
	 * @param name
	 * @return
	 */
	public Expert checkSame(String name, String OrgName);
	
	/**
	 * 更新专家履历信息
	 * @param expertId
	 * @param experience
	 * @return 
	 */
	public void updateExperience(int expertId, String experience);
	
	/**
	 * 更新专家简介信息
	 * @param expertId
	 * @param info
	 */
	public void updateInfo(int expertId, String info);
	
	/**
	 * 更新专家成果信息
	 * @param expertId
	 * @param achievement
	 */
	public void updateAchievement(int expertId, String achievement);
}
