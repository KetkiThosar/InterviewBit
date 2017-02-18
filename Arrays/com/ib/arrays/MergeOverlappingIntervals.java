package com.ib.arrays;

import java.util.ArrayList;

public class MergeOverlappingIntervals {
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (null == intervals || 0 == intervals.size()) {
			return null;
		}
		ArrayList<Interval> mergedInterval = new ArrayList<Interval>();
		int min = intervals.get(0).end;
		int max = intervals.get(0).start;
		boolean merged = false;
		int n = intervals.size();
		for (int i = 1; i < n; i++) {
			Interval interval = intervals.get(i);
			max = Math.max(max, interval.start);
			min = Math.min(min, interval.end);
			if (max < min) {
				merged = true;
				if (mergedInterval.isEmpty()) {
					mergedInterval.add(new Interval(Math.min(max,
							interval.start), Math.max(min, interval.end)));
				}else{
					Interval mI=mergedInterval.get(mergedInterval.size()-1);
					max = Math.max(max, mI.start);
					min = Math.min(min, mI.end);		
				}
			}
			int preStart = interval.start;
			int preEnd = interval.end;

			
			//mergedInterval.add(intervl);
			// startOfInterval.get(i)
		}

		return intervals;

	}

	public static void main(String[] args) {

	}

}
