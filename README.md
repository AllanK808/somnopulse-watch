# SomnoPulse Wear OS Standalone App
Autonomous snoring detection and gentle haptic wake pulse system for Samsung Galaxy Watch (4/5/6/7) & Google Pixel Watch (1/2/3).

## Features
- **Foreground Audio Service**: Keeps listening even when watch screen turns completely off.
- **Low-Frequency Snore Analysis**: Detects sustained rhythmic respiratory decibel peaks (80Hz - 400Hz).
- **Gentle Progressive Waveform**: Uses `VibrationEffect.createWaveform()` to deliver a 2-stage gentle micro-nudge (250ms on / 150ms pause / 250ms on) instead of a jarring continuous alarm.
- **Sleep Hours Schedule**: Only triggers between 22:00 (10 PM) and 07:00 (7 AM).
- **Grace Period**: 20-second pause after vibration to allow the wearer to shift sleeping posture.

## How to Install on Your Galaxy Watch or Pixel Watch
1. **Enable Developer Options on Watch**:
   - Go to **Settings > About Watch > Software Info** and tap **Software Version** 7 times until you see "Developer mode turned on".
2. **Enable Wireless Debugging**:
   - Go to **Settings > Developer Options > Wireless Debugging** and toggle it **ON**. Note the IP address and Port (e.g. `192.168.1.50:5555`).
3. **Build & Sideload**:
   - Open this folder in **Android Studio**.
   - Connect via Wi-Fi: In Android Studio's Device Manager, select **Pair device using Wi-Fi** and enter your watch IP/Port.
   - Click the green **Run (▶)** button to install SomnoPulse onto your watch.
   - *Alternative without PC*: You can install via the **Bugjaeger** app directly from your Android phone!
