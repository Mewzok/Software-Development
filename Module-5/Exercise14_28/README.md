javafx.scene.layout.Pane
^
ClockPane
-hour: int
-minute: int
-second: int
-hourHandVisible: boolean
-minuteHandVisile: boolean
-secondHandVisible: boolean

---

+ClockPane()
+ClockPane(hour: int, minute: int, second: int)
+ClockPane(hour: int, minute: int, second: int, hourHandVisible: boolean, minuteHandVisible: boolean, secondHandVisible: boolean)
+getHour(): int
+setHour(hour: int): void
+getMinute(): int
+setMinute(minute: int): void
+getSecond(): int
+setSecond(second: int): void
+getHourVisible(): boolean
+setHourVisible(hourVisible: boolean): void
+getMinuteVisible(): boolean
+setMinuteVisible(minuteVisible: boolean): void
+getSecondVisible(): boolean
+setSecondVisible(secondVisible: boolean): void
+setCurrentTime(): void
+setWidth(width: double): void
+setHeight(height: double): void
-PaintClock(): void

To only make the hour and minute hands visible, the PaintClock() method can be modified to only add the hand components to the pane if their visibility is set to true.
