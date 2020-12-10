package com.shaip27.algo.array.oneD;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

<P> Solution
The meeting rooms problem or the airplanes on the runaway problem are all similar and they basically wants you to find out the min number of the scarce recources you need given the demand.

In the above example, you can see there are multiple people who booked a meeting room and mentioned the start and end time of their meetings. 
To meet this demand, the operations team would need to know how many meeting rooms they need to facilitate to the team. 
In the case of airlines problem, you will be usually given a list of departure and arrival times and be asked to find out the minimum number of runways you require to enable smooth flow of air traffic.

We sort the meeting based on the end time first, have a counter, compare each start time and the corresponding end time
If start time is lesser, increment the counter.
*/

public class MaximumMeetingInOneRoom {
	
	static class Meeting {
		int startTime;
		int endTime;
		String meetingTitle;
		
		public Meeting(int start, int end, String meetingTitle) {
			this.startTime = start;
			this.endTime = end;
			this.meetingTitle = meetingTitle;
		}
		
		@Override
        public String toString(){
             return "Meeting: "+ this.meetingTitle + "[ Start Time: " + this.startTime + ", End Time: " + this.endTime + "]";
        }
	}
	
	
	public static int findMaxMeetings(ArrayList<Meeting> meetings){
		
		Collections.sort(meetings, (m1,m2) -> m1.endTime-m2.endTime);	
		
		int currentTime = -1;
		int meetingCount =0;
		for(Meeting m : meetings) {
			
			if (m.startTime > currentTime) {
				currentTime = m.endTime;
				meetingCount ++;
				System.out.println("Meeting:" + m);
			}
		}
		return meetingCount;
		
	}

	public static void main(String[] args) {
		
//		Meeting meetingA = new Meeting(1, 3, "A");
//        Meeting meetingB = new Meeting(2, 5, "B");
//        Meeting meetingC = new Meeting(0, 7, "C");
//        Meeting meetingD = new Meeting(6, 8, "D");
//        Meeting meetingE = new Meeting(9, 11, "F");
//        Meeting meetingF = new Meeting(10, 12, "G");
//
//        ArrayList<Meeting> meetings = new ArrayList<>();
//        meetings.add(meetingA);
//        meetings.add(meetingB);
//        meetings.add(meetingC);
//        meetings.add(meetingD);
//        meetings.add(meetingE);
//        meetings.add(meetingF);
		
		Meeting meetingA = new Meeting(0, 30, "A");
        Meeting meetingB = new Meeting(5, 10, "B");
        Meeting meetingC = new Meeting(15, 20, "C");
       

        ArrayList<Meeting> meetings = new ArrayList<>();
        meetings.add(meetingA);
        meetings.add(meetingB);
        meetings.add(meetingC);
   
        
       System.out.println("Mamimum Meeting In One Room:" + findMaxMeetings(meetings));

	}

}
