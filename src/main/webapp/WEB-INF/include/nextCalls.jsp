<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- Recent Post Widget -->
<div ng-app="myApp" ng-controller="UserController" class="widget recent-post">
    <button data-ng-click="lastCalls()">
        Fetch data from server
    </button>
    <h6 class="widget-title">Next Calls</h6>
    <div class="post-box" ng-repeat="(key, value) in list">
        <b>{{ value.receiverName }}</b><br/>
        {{ value.receiverSkype }} <a style="color: #12A5F4" href="skype:{{ value.receiverSkype }}"><i class="fa fa-skype" aria-hidden="true"></i></a>
        <!-- Post Image -->
        <div class="post-image">
            <img src="<s:property value="avatarDefaultPath" />{{ value.receiverPic ? value.receiverPic : 'boy.png' }}" alt="Pic">
        </div>
        <!-- Post Detail -->
        <div class="post-detail">
            <!-- Post Title -->
            <div class="post-title">
                {{ value.title }}
            </div>
            <!-- Post date -->
            <div class="post-date">{{ value.start | date:'medium' }}</div>
        </div>
    </div>
</div>
