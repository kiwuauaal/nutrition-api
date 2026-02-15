-- Add new tables for advanced features

-- Notifications table
CREATE TABLE IF NOT EXISTS notifications (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL REFERENCES users(id),
    message TEXT NOT NULL,
    timestamp TIMESTAMP DEFAULT NOW(),
    type TEXT DEFAULT 'info',
    read BOOLEAN DEFAULT FALSE
);

-- Diet sharing table
CREATE TABLE IF NOT EXISTS diet_sharing (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL REFERENCES users(id),
    recipient_email TEXT NOT NULL,
    permission_level TEXT DEFAULT 'read', -- read, write, full
    expires_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    status TEXT DEFAULT 'active' -- active, expired, revoked
);

-- User badges table
CREATE TABLE IF NOT EXISTS user_badges (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL REFERENCES users(id),
    badge_id TEXT NOT NULL,
    awarded_at TIMESTAMP DEFAULT NOW(),
    badge_info JSON
);

-- Enable Row Level Security (RLS)
ALTER TABLE notifications ENABLE ROW LEVEL SECURITY;
ALTER TABLE diet_sharing ENABLE ROW LEVEL SECURITY;
ALTER TABLE user_badges ENABLE ROW LEVEL SECURITY;

-- Policies for notifications
CREATE POLICY "Users can view own notifications" ON notifications
    FOR SELECT USING (auth.uid() = user_id);

CREATE POLICY "Users can insert own notifications" ON notifications
    FOR INSERT WITH CHECK (auth.uid() = user_id);

CREATE POLICY "Users can update own notifications" ON notifications
    FOR UPDATE USING (auth.uid() = user_id);

-- Policies for diet sharing
CREATE POLICY "Users can view own sharing" ON diet_sharing
    FOR SELECT USING (auth.uid() = user_id);

CREATE POLICY "Users can insert own sharing" ON diet_sharing
    FOR INSERT WITH CHECK (auth.uid() = user_id);

-- Policies for user badges
CREATE POLICY "Users can view own badges" ON user_badges
    FOR SELECT USING (auth.uid() = user_id);

CREATE POLICY "Users can insert own badges" ON user_badges
    FOR INSERT WITH CHECK (auth.uid() = user_id);