<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<tiles:insertTemplate template="/WEB-INF/layouts/userLayout.jsp" flush="true">
    <tiles:putAttribute name="title" value="User Home" />
    <tiles:putAttribute name="content" type="string">
        <div class="row">
            <div class="col-xl-12">
                <div class="page-header">
                    <h3></h3>
                    <small>To see example with events navigate to march 2013</small>
                    <div class="pull-right form-inline">
                        <div class="btn-group">
                            <button class="btn btn-primary" data-calendar-nav="prev"><< Prev</button>
                            <button class="btn" data-calendar-nav="today">Today</button>
                            <button class="btn btn-primary" data-calendar-nav="next">Next >></button>
                        </div>
                        <div class="btn-group">
                            <button class="btn btn-warning active" data-calendar-view="month">Month</button>
                            <button class="btn btn-warning" data-calendar-view="week">Week</button>
                            <button class="btn btn-warning" data-calendar-view="day">Day</button>
                        </div>
                    </div>
                </div>
            </div>
            <br/>
            <div class="col-xl-12">
                <div id="calendar"></div>
            </div>
            <div class="col-xl-12">
                <div class="modal hide fade" id="events-modal">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h3>Event</h3>
                    </div>
                    <div class="modal-body" style="height: 400px">
                    </div>
                    <div class="modal-footer">
                        <a href="#" data-dismiss="modal" class="btn">Close</a>
                    </div>
                </div>
            </div>
        </div>

    </tiles:putAttribute>
    <tiles:putAttribute name="footerScript" type="string">
        <link rel="stylesheet" href="<s:url value="/css/calendar.css" />" />
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

        <script type="text/javascript" src="<s:url value="/js/underscore.min.js" />"></script>
        <script type="text/javascript" src="<s:url value="/js/calendar.js" />"></script>
        <script type="text/javascript">
            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth() + 1; //January is 0!
            var yyyy = today.getFullYear();

            if (dd < 10) {
                dd = '0' + dd;
            }

            if (mm < 10) {
                mm = '0' + mm;
            }

            today = yyyy + "-" + mm + "-" + dd;

            (function ($) {
                "use strict";
                var options = {
                    events_source: '<s:url action="listCalls" />',
                    view: 'week',
                    tmpl_path: '<s:url value="/tmpls/" />',
                    tmpl_cache: false,
                    day: today,
                    onAfterEventsLoad: function (events) {
                        if (!events) {
                            return;
                        }
                        var list = $('#eventlist');
                        list.html('');

                        $.each(events, function (key, val) {
                            $(document.createElement('li'))
                                    .html('<a href="' + val.url + '">' + val.title + '</a>')
                                    .appendTo(list);
                        });
                    },
                    onAfterViewLoad: function (view) {
                        $('.page-header h3').text(this.getTitle());
                        $('.btn-group button').removeClass('active');
                        $('button[data-calendar-view="' + view + '"]').addClass('active');
                    },
                    classes: {
                        months: {
                            general: 'label'
                        }
                    }
                };

                var calendar = $('#calendar').calendar(options);

                $('.btn-group button[data-calendar-nav]').each(function () {
                    var $this = $(this);
                    $this.click(function () {
                        calendar.navigate($this.data('calendar-nav'));
                    });
                });

                $('.btn-group button[data-calendar-view]').each(function () {
                    var $this = $(this);
                    $this.click(function () {
                        calendar.view($this.data('calendar-view'));
                    });
                });

                $('#first_day').change(function () {
                    var value = $(this).val();
                    value = value.length ? parseInt(value) : null;
                    calendar.setOptions({first_day: value});
                    calendar.view();
                });

                $('#language').change(function () {
                    calendar.setLanguage($(this).val());
                    calendar.view();
                });

                $('#events-in-modal').change(function () {
                    var val = $(this).is(':checked') ? $(this).val() : null;
                    calendar.setOptions({modal: val});
                });
                $('#format-12-hours').change(function () {
                    var val = $(this).is(':checked') ? true : false;
                    calendar.setOptions({format12: val});
                    calendar.view();
                });
                $('#show_wbn').change(function () {
                    var val = $(this).is(':checked') ? true : false;
                    calendar.setOptions({display_week_numbers: val});
                    calendar.view();
                });
                $('#show_wb').change(function () {
                    var val = $(this).is(':checked') ? true : false;
                    calendar.setOptions({weekbox: val});
                    calendar.view();
                });
                $('#events-modal .modal-header, #events-modal .modal-footer').click(function (e) {
                    //e.preventDefault();
                    //e.stopPropagation();
                });
            }(jQuery));

        </script>
    </tiles:putAttribute>
</tiles:insertTemplate>
