$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/landingPage.feature");
formatter.feature({
  "line": 1,
  "name": "Landing Page validation",
  "description": "",
  "id": "landing-page-validation",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Display user credential on Landing page",
  "description": "",
  "id": "landing-page-validation;display-user-credential-on-landing-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@LandingPage"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on Home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I verify the home page",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I sould see my loginID on home page",
  "keyword": "Then "
});
formatter.match({
  "location": "LandingPageValidation.i_am_on_home_page()"
});
formatter.result({
  "duration": 15910272930,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageValidation.verify_home_page()"
});
formatter.result({
  "duration": 1252974838,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageValidation.login_id_on_landing_page()"
});
formatter.result({
  "duration": 37734001,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Entry panel",
  "description": "",
  "id": "landing-page-validation;entry-panel",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@LandingPage"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "I sould see Entry panels on home page",
  "rows": [
    {
      "cells": [
        "Date"
      ],
      "line": 12
    },
    {
      "cells": [
        "Level"
      ],
      "line": 13
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "LandingPageValidation.verify_Entrypanel(DataTable)"
});
formatter.result({
  "duration": 1084547637,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Report panel",
  "description": "",
  "id": "landing-page-validation;report-panel",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 15,
      "name": "@LandingPage"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "I sould see Report panels on home page",
  "rows": [
    {
      "cells": [
        "Type"
      ],
      "line": 18
    },
    {
      "cells": [
        "Access"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "LandingPageValidation.verify_Reportpanels(DataTable)"
});
formatter.result({
  "duration": 1086463682,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "View on report panel",
  "description": "",
  "id": "landing-page-validation;view-on-report-panel",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 21,
      "name": "@LandingPage"
    }
  ]
});
formatter.step({
  "line": 23,
  "name": "I click on view link",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I should land on Level \"Reports\" page",
  "keyword": "Then "
});
formatter.match({
  "location": "LandingPageValidation.view_link()"
});
formatter.result({
  "duration": 1086334453,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Reports",
      "offset": 24
    }
  ],
  "location": "LandingPageValidation.page_title(String)"
});
formatter.result({
  "duration": 36962823,
  "error_message": "java.lang.AssertionError: expected:\u003ctrue\u003e but was:\u003cfalse\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:118)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat modules.CommonTestFunctions.reportLogging(CommonTestFunctions.java:34)\r\n\tat stepDefination.LandingPageValidation.page_title(LandingPageValidation.java:79)\r\n\tat ✽.Then I should land on Level \"Reports\" page(features/landingPage.feature:24)\r\n",
  "status": "failed"
});
});