package com.web.back.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StaffExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table STAFF
     *
     * @ibatorgenerated Fri Feb 10 16:00:36 CST 2012
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table STAFF
     *
     * @ibatorgenerated Fri Feb 10 16:00:36 CST 2012
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table STAFF
     *
     * @ibatorgenerated Fri Feb 10 16:00:36 CST 2012
     */
    public StaffExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table STAFF
     *
     * @ibatorgenerated Fri Feb 10 16:00:36 CST 2012
     */
    protected StaffExample(StaffExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table STAFF
     *
     * @ibatorgenerated Fri Feb 10 16:00:36 CST 2012
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table STAFF
     *
     * @ibatorgenerated Fri Feb 10 16:00:36 CST 2012
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table STAFF
     *
     * @ibatorgenerated Fri Feb 10 16:00:36 CST 2012
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table STAFF
     *
     * @ibatorgenerated Fri Feb 10 16:00:36 CST 2012
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table STAFF
     *
     * @ibatorgenerated Fri Feb 10 16:00:36 CST 2012
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table STAFF
     *
     * @ibatorgenerated Fri Feb 10 16:00:36 CST 2012
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table STAFF
     *
     * @ibatorgenerated Fri Feb 10 16:00:36 CST 2012
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table STAFF
     *
     * @ibatorgenerated Fri Feb 10 16:00:36 CST 2012
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List dateList = new ArrayList();
            Iterator iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(((Date)iter.next()).getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andStaffIdIsNull() {
            addCriterion("STAFF_ID is null");
            return this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("STAFF_ID is not null");
            return this;
        }

        public Criteria andStaffIdEqualTo(Integer value) {
            addCriterion("STAFF_ID =", value, "staffId");
            return this;
        }

        public Criteria andStaffIdNotEqualTo(Integer value) {
            addCriterion("STAFF_ID <>", value, "staffId");
            return this;
        }

        public Criteria andStaffIdGreaterThan(Integer value) {
            addCriterion("STAFF_ID >", value, "staffId");
            return this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("STAFF_ID >=", value, "staffId");
            return this;
        }

        public Criteria andStaffIdLessThan(Integer value) {
            addCriterion("STAFF_ID <", value, "staffId");
            return this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("STAFF_ID <=", value, "staffId");
            return this;
        }

        public Criteria andStaffIdIn(List values) {
            addCriterion("STAFF_ID in", values, "staffId");
            return this;
        }

        public Criteria andStaffIdNotIn(List values) {
            addCriterion("STAFF_ID not in", values, "staffId");
            return this;
        }

        public Criteria andStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("STAFF_ID between", value1, value2, "staffId");
            return this;
        }

        public Criteria andStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("STAFF_ID not between", value1, value2, "staffId");
            return this;
        }

        public Criteria andStaffCodeIsNull() {
            addCriterion("STAFF_CODE is null");
            return this;
        }

        public Criteria andStaffCodeIsNotNull() {
            addCriterion("STAFF_CODE is not null");
            return this;
        }

        public Criteria andStaffCodeEqualTo(String value) {
            addCriterion("STAFF_CODE =", value, "staffCode");
            return this;
        }

        public Criteria andStaffCodeNotEqualTo(String value) {
            addCriterion("STAFF_CODE <>", value, "staffCode");
            return this;
        }

        public Criteria andStaffCodeGreaterThan(String value) {
            addCriterion("STAFF_CODE >", value, "staffCode");
            return this;
        }

        public Criteria andStaffCodeGreaterThanOrEqualTo(String value) {
            addCriterion("STAFF_CODE >=", value, "staffCode");
            return this;
        }

        public Criteria andStaffCodeLessThan(String value) {
            addCriterion("STAFF_CODE <", value, "staffCode");
            return this;
        }

        public Criteria andStaffCodeLessThanOrEqualTo(String value) {
            addCriterion("STAFF_CODE <=", value, "staffCode");
            return this;
        }

        public Criteria andStaffCodeLike(String value) {
            addCriterion("STAFF_CODE like", value, "staffCode");
            return this;
        }

        public Criteria andStaffCodeNotLike(String value) {
            addCriterion("STAFF_CODE not like", value, "staffCode");
            return this;
        }

        public Criteria andStaffCodeIn(List values) {
            addCriterion("STAFF_CODE in", values, "staffCode");
            return this;
        }

        public Criteria andStaffCodeNotIn(List values) {
            addCriterion("STAFF_CODE not in", values, "staffCode");
            return this;
        }

        public Criteria andStaffCodeBetween(String value1, String value2) {
            addCriterion("STAFF_CODE between", value1, value2, "staffCode");
            return this;
        }

        public Criteria andStaffCodeNotBetween(String value1, String value2) {
            addCriterion("STAFF_CODE not between", value1, value2, "staffCode");
            return this;
        }

        public Criteria andPasswdIsNull() {
            addCriterion("PASSWD is null");
            return this;
        }

        public Criteria andPasswdIsNotNull() {
            addCriterion("PASSWD is not null");
            return this;
        }

        public Criteria andPasswdEqualTo(String value) {
            addCriterion("PASSWD =", value, "passwd");
            return this;
        }

        public Criteria andPasswdNotEqualTo(String value) {
            addCriterion("PASSWD <>", value, "passwd");
            return this;
        }

        public Criteria andPasswdGreaterThan(String value) {
            addCriterion("PASSWD >", value, "passwd");
            return this;
        }

        public Criteria andPasswdGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWD >=", value, "passwd");
            return this;
        }

        public Criteria andPasswdLessThan(String value) {
            addCriterion("PASSWD <", value, "passwd");
            return this;
        }

        public Criteria andPasswdLessThanOrEqualTo(String value) {
            addCriterion("PASSWD <=", value, "passwd");
            return this;
        }

        public Criteria andPasswdLike(String value) {
            addCriterion("PASSWD like", value, "passwd");
            return this;
        }

        public Criteria andPasswdNotLike(String value) {
            addCriterion("PASSWD not like", value, "passwd");
            return this;
        }

        public Criteria andPasswdIn(List values) {
            addCriterion("PASSWD in", values, "passwd");
            return this;
        }

        public Criteria andPasswdNotIn(List values) {
            addCriterion("PASSWD not in", values, "passwd");
            return this;
        }

        public Criteria andPasswdBetween(String value1, String value2) {
            addCriterion("PASSWD between", value1, value2, "passwd");
            return this;
        }

        public Criteria andPasswdNotBetween(String value1, String value2) {
            addCriterion("PASSWD not between", value1, value2, "passwd");
            return this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("STAFF_NAME is null");
            return this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("STAFF_NAME is not null");
            return this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("STAFF_NAME =", value, "staffName");
            return this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("STAFF_NAME <>", value, "staffName");
            return this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("STAFF_NAME >", value, "staffName");
            return this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("STAFF_NAME >=", value, "staffName");
            return this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("STAFF_NAME <", value, "staffName");
            return this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("STAFF_NAME <=", value, "staffName");
            return this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("STAFF_NAME like", value, "staffName");
            return this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("STAFF_NAME not like", value, "staffName");
            return this;
        }

        public Criteria andStaffNameIn(List values) {
            addCriterion("STAFF_NAME in", values, "staffName");
            return this;
        }

        public Criteria andStaffNameNotIn(List values) {
            addCriterion("STAFF_NAME not in", values, "staffName");
            return this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("STAFF_NAME between", value1, value2, "staffName");
            return this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("STAFF_NAME not between", value1, value2, "staffName");
            return this;
        }

        public Criteria andStaffDescIsNull() {
            addCriterion("STAFF_DESC is null");
            return this;
        }

        public Criteria andStaffDescIsNotNull() {
            addCriterion("STAFF_DESC is not null");
            return this;
        }

        public Criteria andStaffDescEqualTo(String value) {
            addCriterion("STAFF_DESC =", value, "staffDesc");
            return this;
        }

        public Criteria andStaffDescNotEqualTo(String value) {
            addCriterion("STAFF_DESC <>", value, "staffDesc");
            return this;
        }

        public Criteria andStaffDescGreaterThan(String value) {
            addCriterion("STAFF_DESC >", value, "staffDesc");
            return this;
        }

        public Criteria andStaffDescGreaterThanOrEqualTo(String value) {
            addCriterion("STAFF_DESC >=", value, "staffDesc");
            return this;
        }

        public Criteria andStaffDescLessThan(String value) {
            addCriterion("STAFF_DESC <", value, "staffDesc");
            return this;
        }

        public Criteria andStaffDescLessThanOrEqualTo(String value) {
            addCriterion("STAFF_DESC <=", value, "staffDesc");
            return this;
        }

        public Criteria andStaffDescLike(String value) {
            addCriterion("STAFF_DESC like", value, "staffDesc");
            return this;
        }

        public Criteria andStaffDescNotLike(String value) {
            addCriterion("STAFF_DESC not like", value, "staffDesc");
            return this;
        }

        public Criteria andStaffDescIn(List values) {
            addCriterion("STAFF_DESC in", values, "staffDesc");
            return this;
        }

        public Criteria andStaffDescNotIn(List values) {
            addCriterion("STAFF_DESC not in", values, "staffDesc");
            return this;
        }

        public Criteria andStaffDescBetween(String value1, String value2) {
            addCriterion("STAFF_DESC between", value1, value2, "staffDesc");
            return this;
        }

        public Criteria andStaffDescNotBetween(String value1, String value2) {
            addCriterion("STAFF_DESC not between", value1, value2, "staffDesc");
            return this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return this;
        }

        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("ORG_ID =", value, "orgId");
            return this;
        }

        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return this;
        }

        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("ORG_ID >", value, "orgId");
            return this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return this;
        }

        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("ORG_ID <", value, "orgId");
            return this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return this;
        }

        public Criteria andOrgIdIn(List values) {
            addCriterion("ORG_ID in", values, "orgId");
            return this;
        }

        public Criteria andOrgIdNotIn(List values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return this;
        }

        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return this;
        }

        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return this;
        }

        public Criteria andBssOrgIdIsNull() {
            addCriterion("BSS_ORG_ID is null");
            return this;
        }

        public Criteria andBssOrgIdIsNotNull() {
            addCriterion("BSS_ORG_ID is not null");
            return this;
        }

        public Criteria andBssOrgIdEqualTo(Integer value) {
            addCriterion("BSS_ORG_ID =", value, "bssOrgId");
            return this;
        }

        public Criteria andBssOrgIdNotEqualTo(Integer value) {
            addCriterion("BSS_ORG_ID <>", value, "bssOrgId");
            return this;
        }

        public Criteria andBssOrgIdGreaterThan(Integer value) {
            addCriterion("BSS_ORG_ID >", value, "bssOrgId");
            return this;
        }

        public Criteria andBssOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BSS_ORG_ID >=", value, "bssOrgId");
            return this;
        }

        public Criteria andBssOrgIdLessThan(Integer value) {
            addCriterion("BSS_ORG_ID <", value, "bssOrgId");
            return this;
        }

        public Criteria andBssOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("BSS_ORG_ID <=", value, "bssOrgId");
            return this;
        }

        public Criteria andBssOrgIdIn(List values) {
            addCriterion("BSS_ORG_ID in", values, "bssOrgId");
            return this;
        }

        public Criteria andBssOrgIdNotIn(List values) {
            addCriterion("BSS_ORG_ID not in", values, "bssOrgId");
            return this;
        }

        public Criteria andBssOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("BSS_ORG_ID between", value1, value2, "bssOrgId");
            return this;
        }

        public Criteria andBssOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BSS_ORG_ID not between", value1, value2, "bssOrgId");
            return this;
        }

        public Criteria andWorkGroupIdIsNull() {
            addCriterion("WORK_GROUP_ID is null");
            return this;
        }

        public Criteria andWorkGroupIdIsNotNull() {
            addCriterion("WORK_GROUP_ID is not null");
            return this;
        }

        public Criteria andWorkGroupIdEqualTo(Integer value) {
            addCriterion("WORK_GROUP_ID =", value, "workGroupId");
            return this;
        }

        public Criteria andWorkGroupIdNotEqualTo(Integer value) {
            addCriterion("WORK_GROUP_ID <>", value, "workGroupId");
            return this;
        }

        public Criteria andWorkGroupIdGreaterThan(Integer value) {
            addCriterion("WORK_GROUP_ID >", value, "workGroupId");
            return this;
        }

        public Criteria andWorkGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("WORK_GROUP_ID >=", value, "workGroupId");
            return this;
        }

        public Criteria andWorkGroupIdLessThan(Integer value) {
            addCriterion("WORK_GROUP_ID <", value, "workGroupId");
            return this;
        }

        public Criteria andWorkGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("WORK_GROUP_ID <=", value, "workGroupId");
            return this;
        }

        public Criteria andWorkGroupIdIn(List values) {
            addCriterion("WORK_GROUP_ID in", values, "workGroupId");
            return this;
        }

        public Criteria andWorkGroupIdNotIn(List values) {
            addCriterion("WORK_GROUP_ID not in", values, "workGroupId");
            return this;
        }

        public Criteria andWorkGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("WORK_GROUP_ID between", value1, value2, "workGroupId");
            return this;
        }

        public Criteria andWorkGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("WORK_GROUP_ID not between", value1, value2, "workGroupId");
            return this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return this;
        }

        public Criteria andStateIn(List values) {
            addCriterion("STATE in", values, "state");
            return this;
        }

        public Criteria andStateNotIn(List values) {
            addCriterion("STATE not in", values, "state");
            return this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return this;
        }

        public Criteria andStateDateIsNull() {
            addCriterion("STATE_DATE is null");
            return this;
        }

        public Criteria andStateDateIsNotNull() {
            addCriterion("STATE_DATE is not null");
            return this;
        }

        public Criteria andStateDateEqualTo(Date value) {
            addCriterionForJDBCDate("STATE_DATE =", value, "stateDate");
            return this;
        }

        public Criteria andStateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("STATE_DATE <>", value, "stateDate");
            return this;
        }

        public Criteria andStateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("STATE_DATE >", value, "stateDate");
            return this;
        }

        public Criteria andStateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STATE_DATE >=", value, "stateDate");
            return this;
        }

        public Criteria andStateDateLessThan(Date value) {
            addCriterionForJDBCDate("STATE_DATE <", value, "stateDate");
            return this;
        }

        public Criteria andStateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STATE_DATE <=", value, "stateDate");
            return this;
        }

        public Criteria andStateDateIn(List values) {
            addCriterionForJDBCDate("STATE_DATE in", values, "stateDate");
            return this;
        }

        public Criteria andStateDateNotIn(List values) {
            addCriterionForJDBCDate("STATE_DATE not in", values, "stateDate");
            return this;
        }

        public Criteria andStateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STATE_DATE between", value1, value2, "stateDate");
            return this;
        }

        public Criteria andStateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STATE_DATE not between", value1, value2, "stateDate");
            return this;
        }
    }
}