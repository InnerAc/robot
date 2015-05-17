package com.dag.robot.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.dag.robot.entities.Expert;
import com.dag.robot.entities.Orgnization;
import com.dag.robot.entities.Paper;
import com.dag.robot.entities.Patent;
import com.dag.robot.entities.RelExpertOrg;
import com.dag.robot.entities.RelPaperJournal;
import com.dag.robot.entities.Topic;
import com.dag.robot.web.bean.ExpertForList;
import com.dag.robot.web.bean.PaperForList;
import com.dag.robot.web.bean.PatentForList;

public class EntitiesForListUtil {
	
	public static List<ExpertForList> expertForLists(List<Expert> experts){
		List<ExpertForList> expertForLists = new ArrayList<ExpertForList>();
		if(experts == null || experts.size() == 0)
			return expertForLists;
		for(int i = 0; i < experts.size(); i++){
			Expert expert = experts.get(i);
			ExpertForList expertForList = new ExpertForList();
			expertForList.setExpertId(expert.getExpertId());
			expertForList.setName(expert.getName());
			expertForList.setEmail(expert.getEmail());
			expertForList.setGender(expert.getGender());
			expertForList.setPaperNum(expert.getPaperNum());
			expertForList.setPatentNum(expert.getPatentNum());
			
			Set<RelExpertOrg> relExpertOrgs = expert.getRelExpertOrgs();
			List<String> orgs = new ArrayList<String>();
			Iterator<RelExpertOrg> iterator = relExpertOrgs.iterator();
			while(iterator.hasNext()){
				RelExpertOrg relExpertOrg = iterator.next();
				Orgnization orgnization = relExpertOrg.getOrgnization();
				orgs.add(orgnization.getName());
			}
			expertForList.setOrg(StringMergeUtil.stringMerge(orgs));
			expertForLists.add(expertForList);
		}
		return expertForLists;
	}
	
	public static List<PaperForList> paperForLists(List<Paper> papers){
		List<PaperForList> paperForLists = new ArrayList<PaperForList>();
		if(papers == null || papers.size() == 0)
			return paperForLists;
		for(int i = 0; i < papers.size(); i++){
			Paper paper = papers.get(i);
			PaperForList paperForList = new PaperForList();
			paperForList.setPaperId(paper.getPaperId());
			paperForList.setAbs(paper.getAbs());
			paperForList.setKeywords(paper.getKeywords());
			paperForList.setTitle(paper.getTitle());
			
			Set<Topic> topics = paper.getTopics();
			List<Topic> topicList = new ArrayList<Topic>();
			Iterator<Topic> iterator = topics.iterator();
			while(iterator.hasNext()){
				Topic topic = iterator.next();
				topicList.add(topic);
			}
			paperForList.setTopics(topicList);
			
			Set<RelPaperJournal> relPaperJournals = paper.getRelPaperJournals();
			List<RelPaperJournal> relPaperJournals2 = new ArrayList<RelPaperJournal>();
			relPaperJournals2.addAll(relPaperJournals);
			if(relPaperJournals2.size() == 0)
				paperForList.setJournal(null);
			else
				paperForList.setJournal(relPaperJournals2.get(0).getJournal().getName());//论文会议只有一个
			paperForLists.add(paperForList);
		}
		return paperForLists;
	}
	
	public static List<PatentForList> patentForLists(List<Patent> patents){
		List<PatentForList> patentForLists = new ArrayList<PatentForList>();
		if(patents.size() == 0 || patents == null)
			return patentForLists;
		for(int i = 0; i < patents.size(); i++){
			PatentForList patentForList = new PatentForList();
			Patent patent = patents.get(i);
			patentForList.setPatentId(patent.getPatentId());
			patentForList.setApplicant(patent.getApplicant());
			patentForList.setDate(patent.getDate());
			patentForList.setInventor(patent.getInventor());
			patentForList.setTitle(patent.getTitle());
			
			patentForLists.add(patentForList);
		}
		
		return patentForLists;
	}

}
