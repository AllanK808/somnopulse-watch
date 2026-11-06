# SomnoPulse for Samsung Galaxy Watch Ultra & Galaxy Watch Ultra 2

Dedicated setup guide for **Galaxy Watch Ultra (47mm, 2024)** and **Galaxy Watch Ultra 2 (47mm, 2026)**.

## Why the Ultra is Ideal for SomnoPulse
1. **Multi-Day Battery (590 mAh / 800 mAh)**: Unlike standard smartwatches that drain quickly with continuous microphone sensing, the Galaxy Watch Ultra & Ultra 2 can run all-night sleep acoustic monitoring with less than 8-12% battery consumption.
2. **Dedicated Quick Button (Action Button)**:
   - You can map the middle orange Quick Button to start or stop SomnoPulse Sleep Guard immediately upon getting into bed without navigating any menus.
   - Go to **Settings > Buttons and gestures > Quick Button** on your Ultra watch and assign it to **SomnoPulse**.
3. **Titanium Haptic Resonance Tuning**:
   - The included `GalaxyWatchUltraHelper.kt` utilizes calibrated waveform amplitudes (100–180 on Samsung's Linear Resonant Actuator) so the pulse resonates through the titanium case directly into your wrist without rattling or making acoustic noise in the bedroom.

## Step-by-Step Installation on Galaxy Watch Ultra & Ultra 2
1. **Unlock Developer Mode**:
   - On the Ultra, swipe down > tap ⚙️ (Settings) > **About watch > Software info**.
   - Tap **Software version** 7 times until you see "Developer mode turned on".
2. **Turn on Wireless Debugging**:
   - Go back to **Settings > Developer options**.
   - Toggle **ADB debugging** ON.
   - Scroll down to **Wireless debugging** and toggle it ON.
   - Tap "Pair new device" or note your IP & Port (e.g., `192.168.1.55:5555`).
3. **Install (Two Options)**:
   - **Option 1: Using your Galaxy Phone (No PC needed)**:
     - Install **Bugjaeger Mobile ADB** from Google Play on your Galaxy S23/S24/S25/S26 or Android phone.
     - Connect to the watch's IP and port.
     - Go to the "Packages" tab in Bugjaeger, tap **+ (Install)**, and pick the SomnoPulse APK.
   - **Option 2: Using Android Studio**:
     - Open this `WearOS` folder in Android Studio.
     - Pair via Device Manager > Wi-Fi.
     - Press **Run (▶)** to install directly to your Galaxy Watch Ultra or Ultra 2.
