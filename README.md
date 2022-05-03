# Culinary Project

## Recipe Manager TasteIt
I started writing the code but haven't completed it. The last time I was working on it at the end of 2018</br>
<b>Description</b> A personal recipe manager with additional functionality: menu planner, culinary event organizer, ingredients list generator for shoping, filter lists for diet & other purposes, dishes recommender. The idea was to organize it as a social network with private/public accounts</br>
<b>Purpose</b> Organize personal recipes, explore new dishes, plan personal and social culinary events in a convinient way</br>
<b>Inspiration</b> 1. The desire to organize my growing list of recipes 2. Traditions of meeting families and setting the table for the holidays</br> </br>
<b>How it works</b> Each person creates his/her account and adds dishes into one of three categories: favourite, tasty, want to try. Dishes include information about ingredients, steps, tips, time to cook and can have tabs like "soup", "starter" etc. If a person likes some dish on the internet it can be parced automatically with mentioning the link to the source. Then the person can use services: filters, saved lists of dishes, calendar for menu planning for a period of time, ingredients list generator, event organizer</br>
<b>The target audience</b> Everyone who cooks at home. Additional features are for people who likes to explore new dishes, to have social dining</br> 
<b>Monetization</b> Paid features, private accounts, or contextual advertising</br> </br>
<b>[More about functionality](#functionality-of-tasteit)</b>


## Meet & Eat with locals
Magic of testing homemade food in a new place, seeing decorations, artifacts of home life, learning about travel tips and neat local attractions, sharing stories</br> 

<b>Description</b> A website to connect travelers with locals for a homemade lunch or dinner</br>
<b>Purpose</b> Culinary, cultural, and travel experience exchange</br>
<b>Inspiration</b> 1. My experience with CouchSurfing 2. Visiting a local's house for lunch during my trip to Texas in 2018</br> </br>
<b>How it works</b> Each person completes his/her profile. As a traveler, you search for a host in your next travel destination. Then you send a request, where you introduce yourself and explain why you selected this person. If the request is accepted you meet, eat and talk with the local. After the event, you and your host can leave a reference. The same person can be a culinary host at home and a visitor during the travel</br>
<b>The target audience</b> Travelers, gourmands, home cooks, open-minded people curious about travel, cultures, traditions, food</br> 
<b>Monetization</b> Additional paid features or contextual advertising</br> </br>
<b>How is it different from CouchSurfing?</b> It focuses on eating together. The time of the event is shorter. The format is lighter</br>
<b>How is it similar to CouchSurfing?</b> The website connects travelers with locals. It has references that can work as credits for request acceptance. Each user fills a profile and can choose among 3 modes: host, traveler, not accepting requests</br>
<b>Similarity to EatWith</b> After coming to the idea of "Meet & Eat with locals" I searched for similar websites and found the website [EatWith](https://www.eatwith.com/) "Join local hosts near you or abroad for intimate dinner parties, hands-on cooking classes, and interactive workshops". The main difference is that you pay for your culinary experience there

## Functionality of TasteIt
<b>User Profile</b> A profile where a user can view, add and modify personal dishes. A profile can be private (paid) or public (free). Each user has credentials to login to the website. A dish can go into one of three categories: Favourite, Tasty, Want to try (for new dishes). To add a dish a user need to feel the form. Every dish can have multiple tags to help select a list of dishes later</br>
<b>Dish parsing</b> Also, a dish can be parsed from the webpage on the internet automatically if a user selects this option. It can be implemented as a JavaScript plagin. The link to the source webpage will be included to the dish description to protect the authorship</br>
### Navigation
<b>Tabs</b> A user profile contains personal dishes divided into three categories: Favoury, Tasty, Want to try</br>
<b>Tags</b> A user can click on tags to view the related dishes from personal set first and then explore recommendations from other users</br>
<b>Filters</b> Filters help select a dish that matches your mood, diet, ingredients present in the fridge, time you can spend on cooking etc. You choose your preferences about the dishes and the webpage generates results. You can select to form the results from dishes in your profile or to explore from outside. You can filter by the category, tabs and all the information from the dish form</br>
<b>Lists</b> You can save your search result into lists. For instance you can add a list of soups, a list for a specific guest or family member, a list for a diet. List can contain only personal recipes. All lists will be updated automatically when adding a new dishes to the personal profile satisfying specific selected search criteria</br>
### Menu planning
<b>Calendar planner</b> People work on weekdays and buy products on weekends often. Calendar planner helps to choose dishes people plan to cook during the following week or other period of time by adding them into their calendar</br>
<b>Shoping list generator</b> After selecting the dishes for a period of time people can download required ingredients. Then they can untag what they already have or add some additional products. And with this list they can order a products delivery or go to a supermarket.</br>
### Social Networking
<b>Following profiles</b> People can follow profiles that match their culinary interests. It shows updates of new dishes of the selected people</br>
<b>Making friends</b> People can add friends to share culinary experience</br>
<b>Organizing social events</b> Friends can organize common culinary events by selecting dishes together from their profiles, add them to the common virtual table</br>
### Dish exploration
<b>Recomendations</b> Filters will have an explore option to show recommended results from other profiles. If a user likes a dish he/she can add it to the personal profile under the "Want to try" category</br>
<b>Feed from people a user is following</b> A user can open feed to see updates from friends and people he/she is following</br>

