package com.dag.robot.neo.type;

import org.neo4j.graphdb.RelationshipType;

public enum RelTypes implements RelationshipType {
	BELONG_TO,
	RESEARCH,
	WORK_FOR,
	PUBLISH,
	INCLUDE
}
