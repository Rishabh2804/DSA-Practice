class MyCalendarTwo:
    def __init__(self):
        self.calendar = []
        self.overlaps = []

    def book(self, start: int, end: int) -> bool:
        for os, oe in self.overlaps:
            if start < oe and end > os:
                return False
        for cs, ce in self.calendar:
            if start < ce and end > cs:
                self.overlaps.append((max(start, cs), min(end, ce)))
        self.calendar.append((start, end))
        return True