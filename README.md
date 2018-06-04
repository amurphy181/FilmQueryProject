## Film Query Project

note: fix the language output for film ID choice
### Overview
With this project, we built on our earlier work with Java classes and SQL queries to integrate the two into a video-rental store database search program. The user interface for the program is very simple: upon running the Film Query App, the user is prompted for a choice to search for a film by the film's ID or by a generic search term.

Once this choice has been made, the follow-up information will go one of two ways. If the user chooses to search by film ID, the film's title, release year, rating, description, and language are displayed, followed by an output of the list of actors and actresses in the movie. The user then has the option to either return to the main menu or view film details, which if chosen will output all of the table categories for the "film" table within the database, as well as the category assigned to the film.

If the user chooses to search by a term, then any film with that phrase in the title is returned with all of the same information as is returned by a search for film ID.

After each search has been performed, the user is directed back to the initial menu. At this point they can either perform more searches or select "3" to exit the program.

### Topics

#### JDBC

This project provided a heaping portion of context for much of what we have spent the last six weeks learning, chief among which is the ability to use Java as a middle-man between a back-end database and the end-user. Granted, in this case the user still has to interact with the information through a terminal or an IDE, but even still, the framework has now been laid out to provide users with a much more elegant way to parse information in the near-future.

#### MySQL

On a personal note, I have been having a blast with SQL. Combing through databases using these search terms and methods felt immediately comfortable (with some small hiccups along the way, of course) and was intuitive in its use.

Integrating SQL into Java turned out to be logical and intuitive as well. Now that Object-Oriented programming is more firmly entrenched in my head, returning search terms to fields in a Film or Actor object made complete sense. My one issue with SQL - and it's a minor quibble - is that their numbering convention is irredeemably broken, starting at 1 like some simian, analog creature.

#### Maven

I'll spare a quick moment at the end here for Maven, which turned out to be rather helpful when one is trying to hitch two programming languages together. As our class moves along and uses Maven more often, I will have more to say about it, though for now I'll just express my appreciation for the diligent software engineers who made running one language on top of another in order to interact with a database elsewhere is, in two words, completely remarkable. I look forward to seeing where this will lead us!
